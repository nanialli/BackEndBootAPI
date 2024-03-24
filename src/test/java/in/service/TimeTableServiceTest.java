package in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import in.entity.ClassList;
import in.entity.StudentTimeTable;
import in.entity.TeacherTimeTable;
import in.entity.User;
import in.repository.ClassListRepo;
import in.repository.StudentTimeTableRepo;
import in.repository.TeacherTimeTableRepo;
import in.repository.UserRepo;

@SpringBootTest
public class TimeTableServiceTest {

	@Mock
	private StudentTimeTableRepo sttRepo;
	@Mock
	private ClassListRepo clrepo;
	@Mock
	private UserRepo urepo;
	@Mock
	private TeacherTimeTableRepo tttRepo;

	@Mock
	private ClassList classId;
	@InjectMocks
	private TimeTable ttservice;

	@Test
	public void testUpdateStudentTimeTable_success() {
		List<StudentTimeTable> stt = new ArrayList<>();
		when(sttRepo.saveAll(stt)).thenReturn(stt);
		boolean result = ttservice.updateStudentTimeTable(stt);
		assertEquals(true, result);

	}

	@Test
	public void testUpdateStudentTimeTable_failure() {
		List<StudentTimeTable> stt = new ArrayList<>();
		when(sttRepo.saveAll(stt)).thenThrow(new RuntimeException());
		boolean result = ttservice.updateStudentTimeTable(stt);
		assertEquals(false, result);

	}

	@Test
	public void testgetStudentTimeTableByClassName() {

		List<StudentTimeTable> stt = new ArrayList<>();
		stt.add(0, new StudentTimeTable());
		when(sttRepo.findAllByClassList(classId)).thenReturn(stt);
		List<StudentTimeTable> studentTimeTableByClassName = ttservice.getStudentTimeTableByClassName(classId);
		assertEquals(stt, studentTimeTableByClassName);
	}

	@Test
	public void testGetClassList_success() {
	  when ( clrepo.findById(1)).thenReturn(Optional.of(new ClassList()));
	  ClassList classList = ttservice.getClassList ( 1) ;
	  assertNotNull( classList);
	}

	@Test
	public void testGetClassList_failure() {
	  when ( clrepo.findById(1)).thenReturn(Optional.empty());
	  ClassList classList = ttservice.getClassList(1) ;
	  assertEquals(null ,classList);
	}

	@Test
	public void testCreateTimeTableForClass_pass ( ) {
		StudentTimeTable studentTimeTablemock = mock ( StudentTimeTable.class) ;
		
		when(sttRepo.saveAll(anyList())).thenReturn(null) ;
		ttservice.createTimeTableForClass(classId);
		verify(sttRepo).saveAll(anyList()) ;
	}
	@Test
	public void testCreateTimeTableForClass_failure( ) {
		StudentTimeTable studentTimeTablemock = mock ( StudentTimeTable.class) ;
		
		when(sttRepo.saveAll(anyList())).thenThrow(new RuntimeException()) ;
		ttservice.createTimeTableForClass(classId);
		verify(sttRepo).saveAll(anyList()) ;
	}

	@Test
	public void testcreateTeacherTimeTable() {
		TeacherTimeTable teacherTimeTableMock = mock (TeacherTimeTable.class) ;
		User userMock = mock (User.class) ;
		when (tttRepo.saveAll(anyList())).thenReturn(null) ;
		ttservice.createTeacherTimeTable(userMock);
		verify(tttRepo).saveAll(anyList()) ;
	}
	@Test
	public void testGetTeacherTimeTable_success () {
		
		User userMock = mock(User.class) ;
		when(urepo.findById(1)).thenReturn(Optional.of(userMock)) ;
		when(tttRepo.findAllByUser(userMock)).thenReturn(null) ;
		List<TeacherTimeTable> teachertimetable = ttservice.getTeacherTimeTable(1) ;
		assertEquals(null, teachertimetable);
	}
	@Test
	public void testGetTeacherTimeTable_failure () {
		
		
		when(urepo.findById(1)).thenReturn(Optional.empty()) ;
		List<TeacherTimeTable> teachertimetable = ttservice.getTeacherTimeTable(1) ;
		assertEquals(null, teachertimetable);
	}
	@Test
	public void testUpdateTeacherTimeTable () {
		when(tttRepo.saveAll(anyList())).thenReturn(null) ;
		assertEquals(true, ttservice.updateTeacherTimeTable(anyList()));
	}
	@Test
	public void testDeleteTeacherTimeTable ( ) {
		User userMock = mock(User.class) ;
		when( tttRepo.findAllByUser(userMock)).thenReturn(null);
		ttservice.deleteTeacherTimeTable(userMock);
		verify(tttRepo).deleteAll(null) ;
		
	}
	

	
}
