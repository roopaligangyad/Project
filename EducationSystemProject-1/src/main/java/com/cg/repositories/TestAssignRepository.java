package com.cg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.TestAssign;

@Repository
public interface TestAssignRepository extends JpaRepository<TestAssign, Integer> {
	@Query("select obj.marksObtained from TestAssign obj where obj.student.studentId=?1 and obj.test.testId=?2")
	public int getStudentMark(int studentId, int testId);

	@Query("select obj from TestAssign obj where obj.student.studentId=?1")
	public List<TestAssign> getStudentProgress(int studentId);

}
