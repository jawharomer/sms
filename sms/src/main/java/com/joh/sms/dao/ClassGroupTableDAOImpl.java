package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.joh.sms.domain.model.ClassGroupTableD;

public class ClassGroupTableDAOImpl implements ClassGroupTableDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ClassGroupTableD> findAllClassGroupTable(int classGroupId) {
		List<ClassGroupTableD> classGroupTableDs = new ArrayList<>();
		Query query = em.createNativeQuery("SELECT  SWD.I_SCHOOL_WEEK_DAY,\n" + "    WEEK_DAY,\n"
				+ "    GROUP_NAME,LESSON_TIME,\n" + "    SUBJECT_NAME,\n"
				+ "    CONCAT(IFNULL(T.FIRST_NAME, ''),' ',IFNULL(T.MIDDLE_NAME, '')) AS TEACHER_NAME,LT.I_LESSON_TIME\n"
				+ "FROM CLASS_GROUPS CG \n" + "INNER JOIN LESSON_TIMES LT USING(I_CLASS_LEVEL)\n"
				+ "JOIN SCHOOL_WEEK_DAYS SWD\n" + "LEFT OUTER JOIN CLASS_GROUP_TABLES CGT\n"
				+ "ON CG.I_CLASS_GROUP=CGT.I_CLASS_GROUP\n" + "AND LT.I_LESSON_TIME=CGT.I_LESSON_TIME\n"
				+ "LEFT OUTER JOIN CLASS_SUBJECTS CS\n" + "ON CG.I_CLASS_LEVEL=CS.I_CLASS_LEVEL\n"
				+ "AND CGT.I_CLASS_SUBJECT=CS.I_CLASS_SUBJECT\n" + "AND CGT.I_SCHOOL_WEEK_DAY=SWD.I_SCHOOL_WEEK_DAY\n"
				+ "LEFT OUTER JOIN TEACHERS T USING(I_TEACHER)\n"
				+ "WHERE CG.I_CLASS_GROUP= ?1 ORDER BY SWD.I_SCHOOL_WEEK_DAY,LT.I_LESSON_TIME;");
		query.setParameter(1, classGroupId);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {
			ClassGroupTableD classGroupTableD = new ClassGroupTableD();
			classGroupTableD.setSchoolWeekDayId((Integer) row[0]);
			classGroupTableD.setWeekDay((String) row[1]);
			classGroupTableD.setGroupName((String) row[2]);
			classGroupTableD.setLessonTime((Date) row[3]);
			classGroupTableD.setSubjectName((String) row[4]);
			classGroupTableD.setTeacherName((String) row[5]);
			classGroupTableD.setLessonTimeId((Integer) row[6]);

			classGroupTableDs.add(classGroupTableD);
		}
		System.out.println(classGroupTableDs);
		return classGroupTableDs;
	}

	@Override
	public List<ClassGroupTableD> findAllTeacherClassGroupSubject(int teacherId) {
		List<ClassGroupTableD> classGroupTableDs = new ArrayList<>();
		Query query = em
				.createNativeQuery("SELECT DISTINCT CG.GROUP_NAME,CS.SUBJECT_NAME,I_CLASS_GROUP,I_CLASS_SUBJECT\n"
						+ "FROM\n" + "TEACHERS T INNER JOIN\n" + "CLASS_GROUP_TABLES CGT USING(I_TEACHER)\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n"
						+ "INNER JOIN CLASS_SUBJECTS CS USING(I_CLASS_SUBJECT)\n" + "WHERE T.I_TEACHER= ?1 ;");
		query.setParameter(1, teacherId);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {
			ClassGroupTableD classGroupTableD = new ClassGroupTableD();

			classGroupTableD.setGroupName((String) row[0]);
			classGroupTableD.setSubjectName((String) row[1]);
			classGroupTableD.setClassGroupId((Integer) row[2]);
			classGroupTableD.setClassSubjectId((Integer) row[3]);

			classGroupTableDs.add(classGroupTableD);
		}
		return classGroupTableDs;
	}

}
