package com.example

import scalapb.{Message, GeneratedMessage}
import scalapb.GeneratedMessageCompanion
import java.{util => ju}
import _root_.example.protobuf.enums._

object TestMain {
  def main(args: Array[String]): Unit = {
    val messageOptions = getOptions(user.UserPersonalData()).toOption.get
    //Will pass because it was the last one set on the UserPersonalData
    assert(messageOptions.bar == Bar.BAR_ONE)
    //Is not set to the value because it was set before Bar.
    assert(messageOptions.foo == Foo.FOO_TWO)
  }
  private def getOptions[T <: GeneratedMessage with Message[T]](t: T): Either[Exception, MessageOptions] ={
    val options  = t.companion.scalaDescriptor.getOptions
      .extension(EnumsProto.message)
      .toRight(
        new Exception("The extension should be found.")
      )
      println(t.companion.scalaDescriptor.getOptions)
      println(options)
      options
  }
}
