package org.faezCode.npft.Controllers;

import org.faezCode.npft.Dao.TestResultDao;
import org.faezCode.npft.Entity.OverallMarks;
import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.faezCode.npft.Entity.Tests;
import org.faezCode.npft.Service.ParticipantService;
import org.faezCode.npft.Service.TestsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestResultController {

    @Autowired
    TestsService testsService;

    @Autowired
    ParticipantService participantService;

    @Autowired
    TestResultDao testResultDao;


//    @RequestMapping("/test-result-form")
//    public String showForm(@ModelAttribute("participant") Participant participant,
//                           @ModelAttribute("testResult") TestResult testResult, Model model){
//
//        System.out.println(participant);
//        System.out.println(testResult);
//
//        return "home";
//    }

      @RequestMapping("/processTRForm")
      public String processForm(@RequestParam String[] pId, @RequestParam String[] testId, @RequestParam String[] mark, Model model){


          for (int i=0; i<pId.length; i++){
              int trpId = Integer.parseInt(pId[i]);
              int trtestid = Integer.parseInt(testId[i]);
              String s_trMark = mark[i].toUpperCase();
              double i_trMark = 0.0;
              if (mark[i].charAt(0)!='L'){
                  i_trMark = Double.parseDouble(mark[i]);
              }
              int trscore;

              Participant participant = participantService.findById(trpId);
              int age = participant.getAge();
              char gender = participant.getGender();

              System.out.println(trpId +" "+ trtestid +" "+ s_trMark);

              //create session factory
              SessionFactory factory = new Configuration()
                      .configure("hibernate.cfg.xml")
                      .addAnnotatedClass(TestResult.class)
                      .addAnnotatedClass(Participant.class)
                      .addAnnotatedClass(Tests.class)
                      .buildSessionFactory();


              //create session
              Session session = factory.getCurrentSession();


              TestResult testResult = new TestResult();
              try {
                  testResult.setpId(participantService.findById(trpId));
                  testResult.setTestId(testsService.findById(trtestid));
                  testResult.setMark(s_trMark);
                  switch (trtestid) {
                      case 1:
                          if (i_trMark <= 16.4 || i_trMark >= 30) {
                              testResult.setScore(1);
                          } else if ((i_trMark >= 16.5 && i_trMark <= 17.4) || (i_trMark >= 26.1 && i_trMark <= 29.99)) {
                              testResult.setScore(2);
                          } else if ((i_trMark >= 17.5 && i_trMark <= 18.4) || (i_trMark >= 25.1 && i_trMark <= 26.0)) {
                              testResult.setScore(3);
                          } else if (i_trMark >= 23.1 && i_trMark <= 25.0) {
                              testResult.setScore(4);
                          } else {
                              testResult.setScore(5);
                          }
                          break;

                      case 2:
                          if (gender == 'M') {
                              if (age >= 20 && age <= 30) {
                                  if (i_trMark <= 34) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 35 && i_trMark <= 44) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 45 && i_trMark <= 55) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 56 && i_trMark <= 64) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 65) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 31 && age <= 40) {
                                  if (i_trMark <= 24) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 25 && i_trMark <= 34) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 35 && i_trMark <= 44) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 45 && i_trMark <= 54) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 55) {
                                      testResult.setScore(5);
                                  }
                              } else if (age > 40) {
                                  if (i_trMark < 15) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 15 && i_trMark <= 24) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 25 && i_trMark <= 34) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 35 && i_trMark <= 44) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 45) {
                                      testResult.setScore(5);
                                  }
                              }
                          } else if (gender == 'F') {
                              if (age >= 20 && age <= 30) {
                                  if (i_trMark <= 14) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 15 && i_trMark <= 17) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 18 && i_trMark <= 27) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 28 && i_trMark <= 37) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 38) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 31 && age <= 40) {
                                  if (i_trMark <= 9) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 10 && i_trMark <= 14) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 15 && i_trMark <= 24) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 25 && i_trMark <= 34) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 35) {
                                      testResult.setScore(5);
                                  }
                              } else if (age > 40) {
                                  if (i_trMark <= 7) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 8 && i_trMark <= 13) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 14 && i_trMark <= 19) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 20 && i_trMark <= 29) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 30) {
                                      testResult.setScore(5);
                                  }
                              }
                          }
                          break;

                      case 3:
                          if (gender == 'M') {
                              if (age >= 13 && age <= 19) {
                                  if (i_trMark <= 50) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 56 && i_trMark <= 60) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 61 && i_trMark <= 65) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 66) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 20 && age <= 29) {
                                  if (i_trMark <= 45) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 56 && i_trMark <= 60) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 61) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 30 && age <= 39) {
                                  if (i_trMark <= 40) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 41 && i_trMark <= 45) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 56) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 40 && age <= 49) {
                                  if (i_trMark <= 35) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 36 && i_trMark <= 40) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 41 && i_trMark <= 45) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 51) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 50) {
                                  if (i_trMark <= 30) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 31 && i_trMark <= 35) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 36 && i_trMark <= 40) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 41 && i_trMark <= 45) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 46) {
                                      testResult.setScore(5);
                                  }
                              }
                          } else if (gender == 'F') {
                              if (age >= 13 && age <= 19) {
                                  if (i_trMark <= 55) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 56 && i_trMark <= 60) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 61 && i_trMark <= 65) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 66 && i_trMark <= 70) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 71) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 20 && age <= 29) {
                                  if (i_trMark <= 50) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 56 && i_trMark <= 60) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 61 && i_trMark <= 65) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 66) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 30 && age <= 39) {
                                  if (i_trMark <= 45) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 56 && i_trMark <= 60) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 61) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 40 && age <= 49) {
                                  if (i_trMark <= 40) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 41 && i_trMark <= 45) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 51 && i_trMark <= 55) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 56) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 50) {
                                  if (i_trMark <= 35) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 36 && i_trMark <= 40) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 41 && i_trMark <= 45) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 46 && i_trMark <= 50) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 51) {
                                      testResult.setScore(5);
                                  }
                              }
                          }
                          break;

                      case 4:
                          if (gender == 'M') {
                              if (age >= 13 && age <= 19) {
                                  if (i_trMark <= 33) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 34 && i_trMark <= 37) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 38 && i_trMark <= 41) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 42 && i_trMark <= 45) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 46) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 20 && age <= 29) {
                                  if (i_trMark <= 30) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 31 && i_trMark <= 34) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 35 && i_trMark <= 38) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 39 && i_trMark <= 42) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 43) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 30 && age <= 39) {
                                  if (i_trMark <= 27) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 28 && i_trMark <= 31) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 32 && i_trMark <= 35) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 36 && i_trMark <= 39) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 40) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 40 && age <= 49) {
                                  if (i_trMark <= 24) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 25 && i_trMark <= 28) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 29 && i_trMark <= 32) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 33 && i_trMark <= 36) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 37) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 50) {
                                  if (i_trMark <= 21) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 22 && i_trMark <= 25) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 26 && i_trMark <= 29) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 30 && i_trMark <= 33) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 34) {
                                      testResult.setScore(5);
                                  }
                              }
                          } else if (gender == 'F') {
                              if (age >= 13 && age <= 19) {
                                  if (i_trMark <= 23) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 24 && i_trMark <= 27) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 28 && i_trMark <= 31) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 32 && i_trMark <= 35) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 36) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 20 && age <= 29) {
                                  if (i_trMark <= 20) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 21 && i_trMark <= 24) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 25 && i_trMark <= 28) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 29 && i_trMark <= 32) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 33) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 30 && age <= 39) {
                                  if (i_trMark <= 17) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 18 && i_trMark <= 21) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 22 && i_trMark <= 25) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 26 && i_trMark <= 29) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 30) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 40 && age <= 49) {
                                  if (i_trMark <= 14) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 15 && i_trMark <= 18) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 19 && i_trMark <= 22) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 23 && i_trMark <= 26) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 27) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 50) {
                                  if (i_trMark <= 11) {
                                      testResult.setScore(1);
                                  } else if (i_trMark >= 12 && i_trMark <= 15) {
                                      testResult.setScore(2);
                                  } else if (i_trMark >= 16 && i_trMark <= 19) {
                                      testResult.setScore(3);
                                  } else if (i_trMark >= 20 && i_trMark <= 23) {
                                      testResult.setScore(4);
                                  } else if (i_trMark >= 24) {
                                      testResult.setScore(5);
                                  }
                              }
                          }
                          break;

                      case 5:
                          if (gender == 'M') {
                              if (age >= 18 && age <= 25) {
                                  if (s_trMark.compareTo("L2/S8") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L3/S1") >= 0 && s_trMark.compareTo("L4/S5") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L4/S6") >= 0 && s_trMark.compareTo("L5/S4") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L5/S5") >= 0 && s_trMark.compareTo("L6/S8") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L7/S1") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 26 && age <= 35) {
                                  if (s_trMark.compareTo("L2/S8") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L3/S1") >= 0 && s_trMark.compareTo("L4/S3") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L4/S4") >= 0 && s_trMark.compareTo("L5/S2") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L5/S3") >= 0 && s_trMark.compareTo("L6/S6") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L6/S7") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 36 && age <= 45) {
                                  if (s_trMark.compareTo("L2/S2") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L2/S3") >= 0 && s_trMark.compareTo("L2/S8") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L3/S1") >= 0 && s_trMark.compareTo("L3/S8") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L4/S1") >= 0 && s_trMark.compareTo("L5/S4") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L5/S5") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 46 && age <= 55) {
                                  if (s_trMark.compareTo("L1/S7") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L2/S1") >= 0 && s_trMark.compareTo("L2/S6") <= 0) { // ????
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S7") >= 0 && s_trMark.compareTo("L3/S5") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L3/S6") >= 0 && s_trMark.compareTo("L4/S5") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L4/S6") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 56 && age <= 65) {
                                  if (s_trMark.compareTo("L1/S8") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L2/S1") >= 0 && s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L3/S3") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L3/S4") >= 0 && s_trMark.compareTo("L4/S1") <= 0) { // ????
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L4/S2") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 66) {
                                  if (s_trMark.compareTo("L1/S5") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L1/S6") >= 0 && s_trMark.compareTo("L1/S8") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S1") >= 0 && s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L3/S4") <= 0) { // ????
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L3/S5") >= 0) {
                                      testResult.setScore(5);
                                  }
                              }
                          } else if (gender == 'F') {
                              if (age >= 18 && age <= 25) {
                                  if (s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L3/S8") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L4/S1") >= 0 && s_trMark.compareTo("L4/S5") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L4/S6") >= 0 && s_trMark.compareTo("L5/S4") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L5/S5") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 26 && age <= 35) {
                                  if (s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L3/S1") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L3/S2") >= 0 && s_trMark.compareTo("L4/S3") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L4/S4") >= 0 && s_trMark.compareTo("L5/S2") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L5/S3") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 36 && age <= 45) {
                                  if (s_trMark.compareTo("L1/S5") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L1/S6") >= 0 && s_trMark.compareTo("L2/S4") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S5") >= 0 && s_trMark.compareTo("L3/S1") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L3/S2") >= 0 && s_trMark.compareTo("L3/S8") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L4/S1") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 46 && age <= 55) {
                                  if (s_trMark.compareTo("L1/S4") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L1/S5") >= 0 && s_trMark.compareTo("L1/S8") <= 0) { // ????
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S1") >= 0 && s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L3/S2") <= 0) {
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L3/S3") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 56 && age <= 65) {
                                  if (s_trMark.compareTo("L1/S3") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L1/S4") >= 0 && s_trMark.compareTo("L2/S2") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S3") >= 0 && s_trMark.compareTo("L2/S7") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L2/S8") >= 0 && s_trMark.compareTo("L3/S1") <= 0) { // ????
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L3/S2") >= 0) {
                                      testResult.setScore(5);
                                  }
                              } else if (age >= 66) {
                                  if (s_trMark.compareTo("L1/S3") <= 0) {
                                      testResult.setScore(1);
                                  } else if (s_trMark.compareTo("L1/S4") >= 0 && s_trMark.compareTo("L1/S8") <= 0) {
                                      testResult.setScore(2);
                                  } else if (s_trMark.compareTo("L2/S1") >= 0 && s_trMark.compareTo("L2/S5") <= 0) {
                                      testResult.setScore(3);
                                  } else if (s_trMark.compareTo("L2/S6") >= 0 && s_trMark.compareTo("L2/S8") <= 0) { // ????
                                      testResult.setScore(4);
                                  } else if (s_trMark.compareTo("L3/S1") >= 0) {
                                      testResult.setScore(5);
                                  }
                              }
                          }
                          break;
                  }

                  //start a transaction
                  session.beginTransaction();

                  //save the student object
                  System.out.println("Saving the test result....");
                  session.save(testResult);

                  //commit transaction
                  session.getTransaction().commit();

                  System.out.println("Done!");


              }
              finally {
                  factory.close();
              }
          }

          //create session factory
          SessionFactory factory = new Configuration()
                  .configure("hibernate.cfg.xml")
                  .addAnnotatedClass(TestResult.class)
                  .addAnnotatedClass(Participant.class)
                  .addAnnotatedClass(Tests.class)
                  .addAnnotatedClass(OverallMarks.class)
                  .buildSessionFactory();


          //create session
          Session session = factory.getCurrentSession();


          int totalMarks = testResultDao.calcTotalMarks(Integer.parseInt(pId[0]));
          int bmiScore = testResultDao.getTestScore(Integer.parseInt(pId[0]), 1);
          int bleepScore = testResultDao.getTestScore(Integer.parseInt(pId[0]), 5);

          OverallMarks overallMarks = new OverallMarks();
          overallMarks.setpId(participantService.findById(Integer.parseInt(pId[0])));
          overallMarks.setTotalMark(totalMarks);
          overallMarks.setAwardType("");
          if (bleepScore==2 && bmiScore==2 && totalMarks>=10){
              overallMarks.setAwardType("Bronze");
          }
          else if (bleepScore==3 && bmiScore==3 && totalMarks>=15){
              overallMarks.setAwardType("Silver");
          }
          else if (bleepScore>=4 && bmiScore>=4 && totalMarks>=20){
              overallMarks.setAwardType("Gold");
          }
          else if (bleepScore>=4 && bmiScore>=4 && totalMarks<10){
              overallMarks.setAwardType("Heart of Gold");
          }
          else if ((bleepScore>=2 && bleepScore<=3) && (bmiScore>=2 && bmiScore<=3) && totalMarks<10){
              overallMarks.setAwardType("Active Lifestyle Capabilities");
          }

          //start a transaction
          session.beginTransaction();

          //save the student object
          System.out.println("Saving the overall marks....");
          session.save(overallMarks);

          //commit transaction
          session.getTransaction().commit();

          System.out.println("Done!");

          factory.close();


          List<Participant> participants = participantService.getParticipant();

          model.addAttribute("participantList", participants);

          return "home";
      }

}
