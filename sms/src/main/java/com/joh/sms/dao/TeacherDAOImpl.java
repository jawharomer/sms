package com.joh.sms.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.joh.sms.domain.model.TeacherLecturePresentD;

public class TeacherDAOImpl implements TeacherDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TeacherLecturePresentD> findAllTeacherLecturePresent(Date from, Date to) {
		List<TeacherLecturePresentD> teacherLecturePresentDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT I_TEACHER,CONCAT(IFNULL(FIRST_NAME,''),' ',IFNULL(MIDDLE_NAME,''),' ',IFNULL(LAST_NAME,' ')) AS FULL_NAME \n"
						+ ",IFNULL(HIRE_AMOUNT,0) HIRE_AMOUNT,COUNT(CGT.I_TEACHER) AS LECTURE_PER_WEEK,IFNULL(SUM(TP.NUMBER_OF_LECTURES),0) AS TOTAL_LECTURES\n"
						+ ",IFNULL(HIRE_AMOUNT,0)*IFNULL(SUM(TP.NUMBER_OF_LECTURES),0) TOTAL_PAYMENT\n"
						+ "FROM TEACHERS T\n" + "LEFT OUTER JOIN CLASS_GROUP_TABLES CGT USING(I_TEACHER)\n"
						+ "LEFT OUTER JOIN TEACHER_PRESENT TP USING(I_TEACHER)\n"
						+ " WHERE TP.PRESENT_DATE BETWEEN :from AND :to GROUP BY I_TEACHER;");

		query.setParameter("from", from, TemporalType.TIMESTAMP);
		query.setParameter("to", to, TemporalType.TIMESTAMP);

		List<Object[]> resultList = query.getResultList();

		for (Object columns[] : resultList) {
			TeacherLecturePresentD teacherLecturePresentD = new TeacherLecturePresentD();

			teacherLecturePresentD.setTeacherId((Integer) columns[0]);
			teacherLecturePresentD.setTeacherName((String) columns[1]);
			teacherLecturePresentD.setHireAmount((BigDecimal) columns[2]);
			teacherLecturePresentD.setLecturePerWeek(Integer.parseInt("" + columns[3]));
			teacherLecturePresentD.setTotalLectures(Integer.parseInt("" + columns[3]));
			teacherLecturePresentD.setTotalPayment((BigDecimal) columns[5]);

			teacherLecturePresentDs.add(teacherLecturePresentD);
		}

		return teacherLecturePresentDs;
	}
}
