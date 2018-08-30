package com.joh.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.domain.model.EnrollmentD;

public class EnrollmentDAOImpl implements EnrollmentDAOExt {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<EnrollmentD> findAllEnrollment() {
		List<EnrollmentD> enrollmentDs = new ArrayList<>();
		Query query = em.createNativeQuery(
				"SELECT I_ENROLLMENT,concat(ifnull(FIRST_NAME,\"\"),\" \",ifnull(MIDDLE_NAME,\"\"),\" \",ifnull(LAST_NAME,\"\")) AS STUDENT_NAME\n"
						+ ",CG.GROUP_NAME,fee,NOTE,I_STUDENT FROM ENROLLMENTS E\n" + "INNER JOIN STUDENTS S USING(I_STUDENT)\n"
						+ "INNER JOIN CLASS_GROUPS CG USING(I_CLASS_GROUP);");

		List<Object[]> resultList = query.getResultList();

		for (Object row[] : resultList) {
			EnrollmentD enrollmentD = new EnrollmentD();

			enrollmentD.setEnrollmentId((Integer) row[0]);
			enrollmentD.setStudentName((String) row[1]);
			enrollmentD.setGroupName((String) row[2]);
			enrollmentD.setFee((double) row[3]);
			enrollmentD.setNote((String) row[4]);
			enrollmentD.setStudentId((Integer) row[5]);

			enrollmentDs.add(enrollmentD);

		}
		System.out.println(enrollmentDs);
		return enrollmentDs;
	}

}
