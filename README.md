# ISO_DECRYPTER
ISO Byte Array decrypter in plain format
The Java application for decrypting ISO 8583 byte array to plain format built by the Maven

For the operation request must be in byte array format. =
     ` [48,50,48,48,70,50,51,67,52,52,68,49,50,57,69,48,56,50,50,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,50,49,49,54,53,49,57,57,49,49,48,55,55,55,54,55,56,56,56,54,48,48,48,48,48,48,48,48,48,48,48,49,48,48,48,48,48,48,48,53,48,55,49,50,48,52,49,54,53,49,57,50,49,52,49,50,48,52,49,54,48,53,48,55,50,52,48,51,53,52,49,49,48,53,49,48,48,49,50,68,48,48,48,48,48,48,48,48,48,54,53,49,57,57,49,49,51,51,53,49,57,57,49,49,48,55,55,55,54,55,56,56,56,54,68,50,52,48,51,50,50,49,48,48,55,48,57,49,50,57,54,57,50,49,52,53,54,57,55,49,57,48,54,50,50,49,50,78,87,78,50,53,53,55,50,51,48,50,83,79,48,48,48,48,53,54,52,53,50,78,79,87,78,79,87,32,68,73,71,73,84,65,76,32,83,89,83,84,69,77,83,32,76,73,77,73,84,69,68,32,32,32,32,32,32,32,32,32,32,53,54,54,50,51,48,57,70,50,54,48,56,51,52,51,69,55,56,54,53,55,48,69,69,50,57,67,48,57,70,50,55,48,49,52,48,57,70,49,48,49,50,48,49,49,48,54,55,54,48,48,51,48,50,48,48,48,48,56,67,65,49,48,48,48,48,48,48,48,48,48,48,48,48,48,48,70,70,57,70,51,55,48,52,52,50,49,48,54,65,53,67,57,70,51,54,48,50,48,48,69,50,57,53,48,53,48,48,48,48,48,48,56,48,48,48,57,65,48,51,50,50,48,53,48,55,57,67,48,49,48,48,57,70,48,50,48,54,48,48,48,48,48,49,48,48,48,48,48,48,53,70,50,65,48,50,48,53,54,54,53,70,51,52,48,49,48,48,56,50,48,50,51,57,48,48,57,70,49,65,48,50,48,53,54,54,57,70,48,51,48,54,48,48,48,48,48,48,48,48,48,48,48,48,57,70,51,51,48,51,69,48,70,56,67,56,57,70,51,52,48,51,52,52,48,51,48,50,57,70,51,53,48,49,50,50,48,48,54,53,49,57,50,49,52,48,49,53,65,49,48,49,48,49,55,49,49,51,52,52,49,48,49,67,50,51,65,52,66,49,67,56,66,57,70,70,67,67,51,55,51,56,55,65,69,66,57,51,67,56,70,67,56,55,65,68,56,68,55,68,55,56,68,69,49,68,53,53,48,52,49,53,52,68,53,67,56,53,53,57,68,55,57,54,57,49,66]`

> Result


    ----ISO MESSAGE-----
    MTI : 0200
    msg.getMaxField()128
    Field-2 : 519911XXXXXXXX7888
    Field-3 : 000000
    Field-4 : 000001000000
    Field-7 : 0507120416
    Field-11 : 519214
    Field-12 : 120416
    Field-13 : 0507
    Field-14 : 2403
    Field-18 : 5411
    Field-22 : 051
    Field-25 : 00
    Field-26 : 12
    Field-28 : D00000000
    Field-32 : 519911
    Field-35 : 519911XXXXXXXX9129
    Field-37 : 921456971906
    Field-40 : 221
    Field-41 : 2NWN2557
    Field-42 : 2302SO000056452
    Field-43 : NOWNOW DIGITAL SYSTEMS LIMITED          
    Field-49 : 566
    Field-55 : 9F2608343E786570EE29C09F2701409F101201106760030200008CA100000000000000FF9F370442106A5C9F360200E2950500000080009A032205079C01009F02060000010000005F2A0205665F340100820239009F1A0205669F03060000000000009F3303E0F8C89F34034403029F350122
    Field-59 : 519214
    Field-123 : A10101711344101
    Field-128 : C23A4B1C8B9FFCC37387AEB93C8FC87AD8D7D78DE1D5504154D5C8559D79691B



Application screenshot

![Screenshot 2022-05-14 223005](https://user-images.githubusercontent.com/28813274/168448735-3504c88a-8617-45c9-93d5-9cda1958fd2f.png)



The current Java compatibility setting in the project is the version 1.7. If You want to set the version 1.8 or newer, please change the line sourceCompatibility = 1.7 of build.gradle file.

Cloning to your computer
install GIT and Java JDK on your computer
set the operating system environment variable JAVA_HOME (the Java machine executable must be located on %JAVA_HOME%\bin\java.exe)
install Maven Build Tool on your computer
Running under Windows

Running under Linux
build the project by the command gradle assemble build createExe
launch the Java archive file by the command java -jar build/libs/ISO-Decrypter-1.0-SNAPSHOT.jar

To do (my plans to the future)
the application should also be able decrypt hex and connect to direct socket stream get the results in plain format
the text searching should also support regular expressions
