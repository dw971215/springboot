package com.dw.web.moudles.uart.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TooManyListenersException;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;


import com.dw.web.moudles.uart.entity.UartVo;
import com.dw.web.moudles.uart.service.UartService;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SerialComController {
    public static SerialComController serialCom=null;
    // 所有的属性
    @Autowired
    private UartService uartService;

    @PostConstruct
    public void init() {
        serialCom = this;
    }

    static {
        //在该类被ClassLoader加载时就初始化一个SerialCom对象
        if (serialCom == null) {
            serialCom = new SerialComController();
        }
    }
    // 私有化构造函数，不允许用该类来创建对象
    public SerialComController() {}
    /**
     * 查找所有可用端口
     *
     * @return 可用端口名称列表
     */
    /*public  final List<String> getAllPorts() {

        // 获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        List<String> portNameList = new ArrayList<>();
        // 将可用串口名添加到List并返回该List
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }*/


    /**
     * 打开串口
     *
     * @param portName
     *            端口名称
     * @param baudrate
     *            波特率
     * @return 串口对象
     * @throws UnsupportedCommOperationException
     * @throws PortInUseException
     * @throws NoSuchPortException
     */
    public  final SerialPort openPort(String portName, int baudrate/*,JTextArea a*/){

        //通过端口名识别端口
        CommPortIdentifier portIdentifier=null;
        CommPort commPort=null;
        // recvArea=a;
        try {
            portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            //打开端口，并给端口名字和一个timeout（打开操作的超时时间）
            commPort = portIdentifier.open(portName, 2000);
        } catch (NoSuchPortException |PortInUseException e1) {
            e1.printStackTrace();
        }

        //判断是不是串口
        if (commPort instanceof SerialPort) {
            SerialPort serialPort = (SerialPort) commPort;
            //设置一下串口的波特率等参数
            try {
                serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                // 为串口增加必要的侦听事件
                SerialComController serialCom = new SerialComController();
                serialCom.addListener(serialPort);
            } catch (UnsupportedCommOperationException|TooManyListenersException e) {
                e.printStackTrace();
            }
            return serialPort;
        }
        return null;
    }

    /**
     * 关闭串口
     *
     * @param serialPort
     *            待关闭的串口对象
     */
    public void closePort(SerialPort serialPort) {

        if (serialPort != null) {
            serialPort.close();
            serialPort = null;
        }
    }

    /**
     * 往串口发送数据
     *
     * @param serialPort
     *            串口对象
     * @param order
     *            待发送数据
     * @throws IOException
     */
    public  void sendMsg(SerialPort serialPort, byte[] order) {

        OutputStream out = null;
        try {
            out = serialPort.getOutputStream();
            out.write(order);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 从串口读取数据
     *
     * @param serialPort
     *            当前已建立连接的SerialPort对象
     * @return 读取到的数据
     * @throws IOException
     */
    public  byte[] readMsg(SerialPort serialPort) throws IOException {

        InputStream in = null;
        byte[] bytes = null;
        try {
            in = serialPort.getInputStream();
            int bufflenth = in.available(); //获取buffer里的数据长度
            while (bufflenth != 0) {
                bytes = new byte[bufflenth]; //初始化byte数组为buffer中数据的长度
                in.read(bytes);
                bufflenth = in.available();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
                in = null;
            }
        }
        return bytes;
    }

    /**
     * 添加监听器
     *
     * @param serialPort
     * 串口对象
     *
     * @throws TooManyListenersException
     */
    public   void addListener(SerialPort serialPort) throws TooManyListenersException {
        // 设置当有数据到达时唤醒监听接收线程
        serialPort.notifyOnDataAvailable(true);
        // 设置当通信中断时唤醒中断线程
        serialPort.notifyOnBreakInterrupt(true);
        // 给串口添加监听器
        serialPort.addEventListener(new SerialPortEventListener() {

            @Override
            public void serialEvent(SerialPortEvent serialPortEvent) {
                String endData = null;
                switch (serialPortEvent.getEventType()) {
                    case SerialPortEvent.BI: // 10 通讯中断
                        JOptionPane.showMessageDialog(null, "与串口设备通讯中断", "错误", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case SerialPortEvent.OE: // 7 溢位（溢出）错误
                        break;
                    case SerialPortEvent.FE: // 9 帧错误
                        break;
                    case SerialPortEvent.PE: // 8 奇偶校验错误
                        break;
                    case SerialPortEvent.CD: // 6 载波检测
                        break;
                    case SerialPortEvent.CTS: // 3 清除待发送数据
                        break;
                    case SerialPortEvent.DSR: // 4 待发送数据准备好了
                        break;
                    case SerialPortEvent.RI: // 5 振铃指示
                        break;
                    case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
                        break;
                    case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据
                        byte[] data;
                        try {
                            // 读取数据
                            data = readMsg(serialPort);
                            // 如果有界面，则需要将该数据显示到界面中去，下面只是简单地在控制台打印输出
                            String predata = new String(data);
                            endData =  predata.substring(predata.indexOf(":")).substring(1).substring(0,8);
                            System.out.println(endData);

                            //===========处理重复打卡的问题开始===========//
                                UartVo uartVo = serialCom.uartService.selectOne(endData);
                                if(uartVo!=null){
                                    //存在开始打卡记录
                                    Date date1 = getTime();
                                    if(date1.before(uartVo.getStartTime())){
                                        //打卡时间间隔小于5分钟不记录最终打卡时间
                                    }else {
                                        //记录最终打卡时间
                                    serialCom.uartService.updateOne(uartVo.getId());
                                    }
                                }else {
                                    //判断是否可以打卡
                                    UartVo uartVo2 = serialCom.uartService.selectEndTime(endData);
                                    Date date2 = getTime();
                                    if (uartVo2!=null) {
                                        if (date2.before(uartVo2.getEndTime())) {
                                            //最新打卡时间间隔小于5分钟不记录起始打卡时间
                                        } else {
                                            UartVo uartVo1 = new UartVo();
                                            uartVo1.setStuCardId(endData);
                                            int a = serialCom.uartService.add(uartVo1);
                                        }
                                    }else{
                                        UartVo uartVo3 = new UartVo();
                                        uartVo3.setStuCardId(endData);
                                        int a = serialCom.uartService.add(uartVo3);
                                    }
                                }
                            //=====================打卡问题结束==========//
                         /*   if(a>0){
                                sendMsg(serialPort, "1".getBytes());
                            }*/
                            //ENDDATA = endData;
                            // recvArea.append(new String(data));
                            // receiveArea.setCaretPosition(receiveArea.getText().length());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // 返回
                        // sendMsg(serialPort, "123ABC".getBytes());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 将十六进制转化城byte
     *
     * @param string 是f
     * @throws TooManyListenersException
     */
    private byte[] hex2byte(String string) {

        String digital = "0123456789ABCDEF";
        String hex1 = string.replace(" ", "");
        char[] hex2char = hex1.toCharArray();
        byte[] bytes = new byte[hex1.length() / 2];
        byte temp;
        for (int p = 0; p < bytes.length; p++) {
            temp = (byte) (digital.indexOf(hex2char[2 * p]) * 16);
            temp += digital.indexOf(hex2char[2 * p + 1]);
            bytes[p] = (byte) (temp & 0xff);
        }
        return bytes;
    }


    /**
     * 获取当前时间的前5分钟
     * @return
     */
  public Date getTime(){
      Calendar beforTime = Calendar.getInstance();
      beforTime.add(Calendar.MINUTE,-5);
      Date beforD = beforTime.getTime();
      String stringBeforD = new SimpleDateFormat("yyyy:MM:dd HH:MM:ss").format(beforD);
      System.out.println(stringBeforD);
      return  beforD;
  }

}
