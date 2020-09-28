package com.dw;

import com.dw.web.moudles.uart.controller.SerialComController;
import gnu.io.SerialPort;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.dw.web.moudles"})
@MapperScan("com.dw.mappings.moudles.*")
public class PtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtApplication.class, args);
        /*SerialComController serialCom = new SerialComController();
        SerialPort port= serialCom.openPort("COM3", 115200);*/
    }

}
