package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.hardware.HiTechnicNxtColorSensor;
import com.qualcomm.hardware.HiTechnicNxtLightSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


/**
 * Created by SrinivasaRao on 11/1/2015.
 */
public class MountainClimb_AUTO extends LinearOpMode{

    DcMotor rightFront;
    DcMotor leftFront;
    DcMotor rightBack;
    DcMotor leftBack;
    HiTechnicNxtColorSensor NXTcolorSensor;
    HiTechnicNxtLightSensor NXTlightSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        rightFront = hardwareMap.dcMotor.get("rightF");
        rightBack = hardwareMap.dcMotor.get("rightB");

        leftFront = hardwareMap.dcMotor.get("leftF");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack = hardwareMap.dcMotor.get("leftB");
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        //NXTcolorSensor = hardwareMap.

    }

}
