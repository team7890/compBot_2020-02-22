/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kCANIds;
import frc.robot.Constants.kPneumatics;
import frc.robot.Constants.kSpeeds;

public class Intake extends SubsystemBase {
  Victor objIntakeMotor = new Victor(kCANIds.iIntake);
  Solenoid objSolenoidIntake = new Solenoid(kPneumatics.iIntake);
  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void rollIn() {
    objIntakeMotor.set(kSpeeds.dIntake); // TODO: May want to change the speed !!!
  }

  public void rollOut() {
    objIntakeMotor.set(-kSpeeds.dIntake);
  }

  public void stop() {
    objIntakeMotor.stopMotor(); 
  }

  public void raise() {
    objSolenoidIntake.set(false);
  }

  public void lower() {
    objSolenoidIntake.set(true);
  }
}
