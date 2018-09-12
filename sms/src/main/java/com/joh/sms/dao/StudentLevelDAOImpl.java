package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.joh.sms.domain.model.StudentPresentD;
import com.joh.sms.model.ClassSubject;
import com.joh.sms.model.Student;
import com.joh.sms.model.StudentLevel;

public class StudentLevelDAOImpl implements StudentLevelDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<StudentLevel> findAllSubjectStudentLevel(int classSubjectId,int classGroupId) {

		List<StudentLevel> studentLevels = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT S.I_STUDENT,S.FIRST_NAME,S.MIDDLE_NAME,S.LAST_NAME,CS.I_CLASS_SUBJECT,CS.SUBJECT_NAME,SL.I_STUDENT_LEVEL,LEVEL FROM CLASS_SUBJECTS CS\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_LEVEL)\n"
						+ "INNER JOIN ENROLLMENTS E USING(I_CLASS_GROUP)\n" + "INNER JOIN STUDENTS S USING(I_STUDENT)\n"
						+ "LEFT OUTER JOIN STUDENT_LEVELS SL  ON S.I_STUDENT=SL.I_STUDENT AND CS.I_CLASS_SUBJECT=SL.I_CLASS_SUBJECT\n" + "WHERE CS.I_CLASS_SUBJECT=?1  AND CG.I_CLASS_GROUP=?2 ORDER BY S.I_STUDENT ;");

		query.setParameter(1, classSubjectId);
		query.setParameter(2, classGroupId);

		List<Object[]> rows = query.getResultList();

		for (Object columns[] : rows) {

			StudentLevel studentLevel = new StudentLevel();

			Student student = new Student();

			student.setId((Integer) columns[0]);
			if (columns[1] != null)
				student.setFirstName((String) columns[1]);
			if (columns[2] != null)
				student.setMiddleName((String) columns[2]);
			if (columns[3] != null)
				student.setLastName((String) columns[3]);
			studentLevel.setStudent(student);

			ClassSubject classSubject = new ClassSubject();
			if (columns[4] != null)
				classSubject.setId((Integer) columns[4]);
			if (columns[5] != null)
				classSubject.setName((String) columns[5]);
			studentLevel.setClassSubject(classSubject);

			if (columns[6] != null)
				studentLevel.setId((Integer) columns[6]);
			if (columns[7] != null)
				studentLevel.setLevel((Integer) columns[7]);

			studentLevels.add(studentLevel);

		}

		return studentLevels;
	}

}
