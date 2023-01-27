package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController   //it will tell to java compiler, In this class we will have REST API's.
public class StudentController{

//        //now i want to store the information
//        Map<Integer,Student> db=new HashMap<>(); // here key is the rollno(Integer),value is(Student)Student information
//
//        //Adding the information
//        @PostMapping("/add_student")   //end point
//        //adding using request body
//        public String addStudent(@RequestBody Student student){  //this student object is given by client.
//            int rollNo=student.getRollNo();  // here i will get rollno in all information (from Class Student)
//            db.put(rollNo,student);          // here i will add student in hashmap along with rollno.
//            return "Student added successfully";
//
//        }
//
//        //get information
//    //using requestparameter
//        @GetMapping("/get_student")  // end point
//        public Student getStudent(@RequestParam("q") int rollNo){ // here i getting the information of student based on rollNo.
//            return db.get(rollNo);
//        }
//
//       //get information
//    //using path parameter
////    @GetMapping("/get_student/{rollNo}")
////    public Student getStudent (@PathVariable("rollNo") int rollNo){
////        return db.get(rollNo);
////    }
//
//
//    //here i delete the student from database
//    @DeleteMapping("/delete_student")
//    public String deleteStudent(@RequestParam("rollNo") int rollNo){
//            db.remove(rollNo);
//            return "Student deleted successfully";
//    }
//
//    //here i update a student details
//    @PutMapping("/update_student")
//    public String updateStudent(@RequestParam("rollNo") int rollNo,@RequestParam("name") String name){
//            if(!db.containsKey(rollNo)){
//                return "Invalid rollNo";
//            }
//
//            Student student=db.get(rollNo);
//            student.setName(name);
//
//            return "Updated Successfully";
//    }

    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response=studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int rollNo){
        Student student=studentService.getStudent(rollNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete_student")
    public ResponseEntity deleteStudent(@RequestParam("p") int rollNo){
        String response=studentService.deleteStudent(rollNo);
        if(response.equals("Invalid rollNo")){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("rollNo") int rollNo,@RequestParam("name") String name){
        String response=studentService.updateStudent(rollNo,name);
        if(response.equals("Invalid rollNo")){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
