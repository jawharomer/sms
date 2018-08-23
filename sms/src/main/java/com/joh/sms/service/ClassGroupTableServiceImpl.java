package com.joh.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.sms.dao.ClassGroupTableDAO;
import com.joh.sms.domain.model.ClassGroupTableD;
import com.joh.sms.model.ClassGroupTable;

@Service
public class ClassGroupTableServiceImpl implements ClassGroupTableService {

	@Autowired
	private ClassGroupTableDAO classGroupTableDAO;

	@Override
	public List<ClassGroupTableD> findAllClassGroupTable(int id) {
		return classGroupTableDAO.findAllClassGroupTable(id);
	}

	@Override
	@Transactional
	public ClassGroupTable save(ClassGroupTable classGroupTable) {
		return classGroupTableDAO.save(classGroupTable);
	}

	@Override
	public List<ClassGroupTableD> findAllTeacherClassGroupSubject(int teacherId) {
		return classGroupTableDAO.findAllTeacherClassGroupSubject(teacherId);
	}

}
