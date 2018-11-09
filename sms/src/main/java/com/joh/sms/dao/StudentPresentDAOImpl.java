package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.joh.sms.domain.model.StudentPresentD;

public class StudentPresentDAOImpl implements StudentPresentDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<StudentPresentD> findAllStudentPresentByClassGroupId(int id) {
		List<StudentPresentD> studentPresentDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT S.I_STUDENT,concat(ifnull(FIRST_NAME,''),' ',ifnull(MIDDLE_NAME,''),' ',ifnull(LAST_NAME,'')) studentName,SUM(if(ATTEND=1,1,0)) attendDays,SUM(if(ATTEND=0,1,0)) absentDays FROM STUDENTS S\n"
						+ "INNER JOIN ENROLLMENTS E USING(I_STUDENT) \n"
						+ "LEFT OUTER JOIN STUDENT_PRESENTS USING(I_STUDENT)\n" + "WHERE I_CLASS_GROUP= ?1 "
						+ "GROUP BY S.I_STUDENT;");

		query.setParameter(1, id);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {

			StudentPresentD studentPresentD = new StudentPresentD();

			studentPresentD.setStudentId((Integer) row[0]);
			studentPresentD.setStudentName((String) row[1]);
			studentPresentD.setAttendDays(Integer.parseInt("" + row[2]));
			studentPresentD.setAbsentDays(Integer.parseInt("" + row[3]));

			studentPresentDs.add(studentPresentD);

		}
		System.out.println(studentPresentDs);
		return studentPresentDs;
	}

	@Override
	public List<StudentPresentD> findAllStudentPresentByClassGroupIdAndPresentDate(int id, Date date) {
		List<StudentPresentD> studentPresentDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT SP.I_STUDENT_PRESENT,S.I_STUDENT,concat(ifnull(FIRST_NAME,''),' ',ifnull(MIDDLE_NAME,''),' ',ifnull(LAST_NAME,'')) studentName,IF(ATTEND=1,1,0) ATTEND\n"
						+ "FROM STUDENTS S\n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n"
						+ "INNER JOIN STUDENT_PRESENTS SP USING(I_STUDENT) \n" + "WHERE I_CLASS_GROUP=?1 \n"
						+ "AND SP.PRESENT_DATE=?2 \n" + "ORDER BY studentName;");

		query.setParameter(1, id);
		query.setParameter(2, date, TemporalType.DATE);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {

			StudentPresentD studentPresentD = new StudentPresentD();
			studentPresentD.setStudentPresentId((Integer) row[0]);
			studentPresentD.setStudentId((Integer) row[1]);
			studentPresentD.setStudentName((String) row[2]);
			boolean attend = Integer.parseInt("" + row[3]) == 1 ? true : false;
			studentPresentD.setAttend(attend);
			studentPresentDs.add(studentPresentD);
		}
		return studentPresentDs;
	}

	@Override
	public List<Date> findAllClassGroupPresents(int id) {
		List<Date> dates = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT DISTINCT PRESENT_DATE \n" + "FROM STUDENTS S\n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
						+ "INNER JOIN STUDENT_PRESENTS USING(I_STUDENT) WHERE I_CLASS_GROUP=?\n"
						+ "ORDER BY PRESENT_DATE DESC;");

		query.setParameter(1, id);

		List<Date> resultList = query.getResultList();
		if (resultList != null)
			dates.addAll(resultList);

		return dates;
	}

	@Override
	public void deleteClassGroupPresent(int id, Date date) {
		List<Date> dates = new ArrayList<>();
		Query query = em.createNativeQuery(
				"DELETE SP FROM STUDENT_PRESENTS SP\n" + "INNER JOIN ENROLLMENTS E USING (I_STUDENT)\n"
						+ "WHERE I_CLASS_GROUP=?1 \n" + "AND PRESENT_DATE=?2 ");

		query.setParameter(1, id);
		query.setParameter(2, date, TemporalType.DATE);
		query.executeUpdate();
	}

}
