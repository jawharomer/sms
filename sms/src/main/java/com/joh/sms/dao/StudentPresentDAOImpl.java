package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

}
