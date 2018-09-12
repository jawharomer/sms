package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.joh.sms.domain.model.StudentSubjectMarkD;

public class StudentSubjectMarkDAOImpl implements StudentSubjectMarkDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<StudentSubjectMarkD> findAllStudentStudentSubjectMark(int studentId) {
		List<StudentSubjectMarkD> studentSubjectMarkDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT CONCAT(IFNULL(S.FIRST_NAME, ''),' ',IFNULL(S.MIDDLE_NAME, ''),' ',IFNULL(S.LAST_NAME, '')) AS STUDENT_NAME,CS.SUBJECT_NAME,CM.MARK_NAME,CM.MARK_LIMIT,SSM.MARK \n"
						+ ",S.I_STUDENT,CM.I_CLASS_MARK,CS.I_CLASS_SUBJECT,SSM.I_STUDENT_SUBJECT_MARK\n"
						+ "FROM STUDENTS S \n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n"
						+ "INNER JOIN CLASS_SUBJECTS CS USING(I_CLASS_LEVEL)\n"
						+ "INNER JOIN CLASS_MARKS CM USING(I_CLASS_LEVEL)\n"
						+ "LEFT OUTER JOIN STUDENT_SUBJECT_MARKS SSM\n" + "ON S.I_STUDENT=SSM.I_STUDENT\n"
						+ "AND CS.I_CLASS_SUBJECT=SSM.I_CLASS_SUBJECT AND CM.I_CLASS_MARK=SSM.I_CLASS_MARK\n"
						+ "WHERE S.I_STUDENT= ?1 " + "ORDER BY S.I_STUDENT,CS.I_CLASS_SUBJECT,CM.I_CLASS_MARK;");
		query.setParameter(1, studentId);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {
			StudentSubjectMarkD studentSubjectMarkD = new StudentSubjectMarkD();
			studentSubjectMarkD.setStudentName((String) row[0]);
			studentSubjectMarkD.setSubjectName((String) row[1]);
			studentSubjectMarkD.setMarkName((String) row[2]);
			studentSubjectMarkD.setMarkLimit((Integer) row[3]);
			studentSubjectMarkD.setMark((Double) row[4]);
			studentSubjectMarkD.setStudentId((Integer) row[5]);
			studentSubjectMarkD.setClassMarkId((Integer) row[6]);
			studentSubjectMarkD.setClassSubjectId((Integer) row[7]);
			studentSubjectMarkD.setStudentSubjectMarkId((Integer) row[8]);

			studentSubjectMarkDs.add(studentSubjectMarkD);
		}
		return studentSubjectMarkDs;
	}

	@Override
	public List<StudentSubjectMarkD> findAllStudentSubjectMarkBySubjectIdAndGroupId(int subjectId,int classGroupId) {
		List<StudentSubjectMarkD> studentSubjectMarkDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT CONCAT(IFNULL(S.FIRST_NAME, ''),' ',IFNULL(S.MIDDLE_NAME, ''),' ',IFNULL(S.LAST_NAME, '')) AS STUDENT_NAME,CS.SUBJECT_NAME,CM.MARK_NAME,CM.MARK_LIMIT,SSM.MARK \n"
						+ ",S.I_STUDENT,CM.I_CLASS_MARK,CS.I_CLASS_SUBJECT,SSM.I_STUDENT_SUBJECT_MARK\n"
						+ "FROM STUDENTS S \n" + "INNER JOIN ENROLLMENTS E USING(I_STUDENT)\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP)\n"
						+ "INNER JOIN CLASS_SUBJECTS CS USING(I_CLASS_LEVEL)\n"
						+ "INNER JOIN CLASS_MARKS CM USING(I_CLASS_LEVEL)\n"
						+ "LEFT OUTER JOIN STUDENT_SUBJECT_MARKS SSM\n" + "ON S.I_STUDENT=SSM.I_STUDENT\n"
						+ "AND CS.I_CLASS_SUBJECT=SSM.I_CLASS_SUBJECT AND CM.I_CLASS_MARK=SSM.I_CLASS_MARK\n"
						+ "WHERE CS.I_CLASS_SUBJECT= ?1 AND CG.I_CLASS_GROUP= ?2 " + "ORDER BY S.I_STUDENT,CS.I_CLASS_SUBJECT,CM.I_CLASS_MARK;");
		query.setParameter(1, subjectId);
		query.setParameter(2, classGroupId);

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {
			StudentSubjectMarkD studentSubjectMarkD = new StudentSubjectMarkD();
			studentSubjectMarkD.setStudentName((String) row[0]);
			studentSubjectMarkD.setSubjectName((String) row[1]);
			studentSubjectMarkD.setMarkName((String) row[2]);
			studentSubjectMarkD.setMarkLimit((Integer) row[3]);
			studentSubjectMarkD.setMark((Double) row[4]);
			studentSubjectMarkD.setStudentId((Integer) row[5]);
			studentSubjectMarkD.setClassMarkId((Integer) row[6]);
			studentSubjectMarkD.setClassSubjectId((Integer) row[7]);
			studentSubjectMarkD.setStudentSubjectMarkId((Integer) row[8]);

			studentSubjectMarkDs.add(studentSubjectMarkD);
		}
		return studentSubjectMarkDs;
	}

}
