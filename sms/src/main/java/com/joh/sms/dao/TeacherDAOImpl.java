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
		Query query = em.createNativeQuery("SELECT\n"
				+ "        I_TEACHER,CONCAT(IFNULL(FIRST_NAME,''),' ',IFNULL(MIDDLE_NAME,''),' ',IFNULL(LAST_NAME,' ')) AS FULL_NAME  \n"
				+ "        ,IFNULL(HIRE_AMOUNT,0) HIRE_AMOUNT,\n"
				+ "         COUNT(CGT.I_TEACHER) AS LECTURE_PER_WEEK,IFNULL(NUMBER_OF_LECTURES,0) TOTAL_LECTURES\n"
				+ "        ,IFNULL(HIRE_AMOUNT,0)*IFNULL(NUMBER_OF_LECTURES,0) TOTAL_PAYMENT \n" + "    FROM\n"
				+ "        TEACHERS T \n" + "    LEFT OUTER JOIN\n"
				+ "        CLASS_GROUP_TABLES CGT USING(I_TEACHER) \n" + "    LEFT OUTER JOIN\n"
				+ "       (SELECT I_TEACHER,SUM(NUMBER_OF_LECTURES) AS NUMBER_OF_LECTURES\n"
				+ "       FROM TEACHER_PRESENT\n" + "       WHERE\n" + "        PRESENT_DATE BETWEEN :from AND :to\n"
				+ "       GROUP BY I_TEACHER\n" + "       ) TP USING(I_TEACHER)  \n" + "    GROUP BY\n"
				+ "        I_TEACHER;");

		query.setParameter("from", from, TemporalType.TIMESTAMP);
		query.setParameter("to", to, TemporalType.TIMESTAMP);

		List<Object[]> resultList = query.getResultList();

		for (Object columns[] : resultList) {
			TeacherLecturePresentD teacherLecturePresentD = new TeacherLecturePresentD();

			teacherLecturePresentD.setTeacherId((Integer) columns[0]);
			teacherLecturePresentD.setTeacherName((String) columns[1]);
			teacherLecturePresentD.setHireAmount((BigDecimal) columns[2]);
			teacherLecturePresentD.setLecturePerWeek(Integer.parseInt("" + columns[3]));
			teacherLecturePresentD.setTotalLectures(Integer.parseInt("" + columns[4]));
			teacherLecturePresentD.setTotalPayment((BigDecimal) columns[5]);

			teacherLecturePresentDs.add(teacherLecturePresentD);
		}

		return teacherLecturePresentDs;
	}
}
