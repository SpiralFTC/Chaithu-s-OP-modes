package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.util.Range;


public class TankDrive extends OpMode_Methods {




    public TankDrive() {
    }

    @Override
    public void loop() {
        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(ServoPosition);
        double rightPower = -gamepad1.left_stick_y;
        double leftPower = -gamepad1.right_stick_y;
        rightPower = Range.clip(rightPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        right.setPower(leftPower);
        left.setPower(rightPower);
        if (gamepad2.a) {
            ServoPosition += servoDelta;

        }
        if (gamepad2.y) {
            ServoPosition -= servoDelta;
        }

        if (gamepad2.x) {

            armPosition += armDelta;
        }

        if (gamepad2.b) {
            armPosition -= armDelta;
        }


        armPosition = Range.clip(armPosition, 0.01, 0.69);
        ServoPosition = Range.clip(ServoPosition, 0.01, 0.99);

        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(armPosition);

    }


}

