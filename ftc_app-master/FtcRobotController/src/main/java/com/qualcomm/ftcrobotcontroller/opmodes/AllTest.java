package com.qualcomm.ftcrobotcontroller.opmodes;



public class AllTest extends OpModeMethods {


    @Override
    public void loop() {

right.setPower(1);
       sleep(500);
        left.setPower(1);
        sleep(500);


        right.setPower(1);
        left.setPower(1);
       sleep(500);


        RightServo.setPosition(0.99);


         sleep(500);


        RightServo.setPosition(0.01);
       sleep(500);


        LeftServo.setPosition(0.99);

       sleep(500);

        LeftServo.setPosition(0.01);
        sleep(500);



    }
}
