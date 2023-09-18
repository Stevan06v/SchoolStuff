<?php

# data -painful 

# keys = days
# values = json objects
$adventCalender = array(
    1 => '{"imgsrc":"./img/sensors/dht11.png","name":"DHT11- Sensor","description":"With a Python script running on your Raspberry Pi, we will read the ambient temperature and humidity. When you have completed this tutorial, you will be able to connect the DHT11 sensor to your Pi via the GPIO pins. You’ll also have the basic code to convert the output signal of the sensor to useable information in your Python script. This tutorial can also be used for a DHT22 sensor.", "topic":"sensor"} ',
    2 => '{"imgsrc":"./img/sensors/infrared.png","name":"Infrarot- Sensor","description":"The IR (infrared) sensor is mostly used to detect the motion of the objects in the surroundings as well as the detection of the presence of the objects. We can interface the IR sensor with the Raspberry Pi 4 in different projects and in this write-up we have discussed the method by which it can be interfaced with Raspberry Pi 4.", "topic":"sensor" }',
    3 => '{"imgsrc":"./img/sensors/loetset.png","name":"Loetset","description":"Brazing is a thermal process for the cohesive joining of materials, whereby a liquid phase is created by melting a solder (fusion brazing) or by diffusion at the interfaces (diffusion brazing). A surface alloy is produced, but the workpiece is not melted in depth: the liquidus temperature of the base materials is not reached. After solidification of the brazing alloy, a material-to-material bond is produced, as in welding.","topic":"sensor"}',
    4 => '{"imgsrc":"./img/sensors/moisture.png","name":"Moisture -Sensor","description":"The Grove - Capacitive Moisture Sensor (Corrosion Resistant) is a soil moisture sensor based on capacitance changes. Compared with resistive sensors, capacitive sensors do not require direct exposure of the metal electrodes, which can significantly reduce the erosion of the electrodes. Hence, we call it Corrosion Resistant.","topic":"sensor"}',
    5 => '{"imgsrc":"./img/sensors/lcd.png","name":"LCD -Screen","description":"The LCD160CR class provides an interface to the display. Create an instance of this class and use its methods to draw to the LCD and get the status of the touch panel.","topic":"sensor"}',
    6 => '{"imgsrc":"./img/sensors/movement.png","name":"Movement -Sensor","description":"Its easy to use a PIR sensor with CircuitPython using simple digital inputs.  The PIR sensor looks and acts kind of like a button or switch, i.e. its only ever a high or low logic level, so you dont need any special libraries or other code to read one from Python.  It will help to familiarize yourself with CircuitPython digital inputs and outputs before continuing though!","topic":"sensor"}',

    7 => '{"imgsrc":"./img/coding/c.png","name":"Micro C SDK","description":"C is a procedural language that provides no support for objects and classes. C++ is a combination of OOP and procedural programming languages. C has 32 keywords and C++ has 63 keywords. C supports built-in data types, while C++ supports both built-in and user-defined data types.","topic":"coding"}',
    8 => '{"imgsrc":"./img/coding/debian.png","name":"Rasbian Bullseye","description":"Every two years, Debian Linux, on which Raspberry Pi OS is based, gets a major version upgrade. Debian ‘buster’ has been the basis of Raspberry Pi OS since its release in 2019, and Debian ‘bullseye’ was released in August. (As some of you may know, Debian name their versions after characters in Disney/Pixar’s Toy Story films – Bullseye was Woody’s horse in Toy Story 2.)","topic":"coding"}',
    9 => '{"imgsrc":"./img/coding/mircopython.png","name":"Micro Python","description":"MicroPython is a full Python compiler and runtime that runs on the bare-metal. You get an interactive prompt (the REPL) to execute commands immediately, along with the ability to run and import scripts from the built-in filesystem. The REPL has history, tab completion, auto-indent and paste mode for a great user experience.","topic":"coding"}',
    10 =>'{"imgsrc":"./img/coding/micropythonGUIDE.jpg","name":"Micro Python Guide","description":"Raspberry Pi Pico is a miniature marvel, putting the same technology that underpins everything from smart home systems to industrial factories in the palm of your hand. Whether you’re looking to learn about the MicroPython programming language, take your first steps in physical computing, or want to build a hardware project, Raspberry Pi Pico – and its amazing community – will support you every step of the way.","topic":"coding"}',
    11 =>'{"imgsrc":"./img/coding/java.png","name":"Java -Raspberry","description":"In Raspberry Pi, the package Java is already installed, but if it is not installed, then it can be installed using simple commands. There are two types of packages in the Raspberry Pi operating system repository which are JDK (Java Development Kit) and JRE (Java Runtime Environment). The JDK includes the JRE and the JRE includes the JVM (Java Virtual Machine).","topic":"coding"}',
    12 =>'{"imgsrc":"./img/coding/rust.png","name":"Rust -Raspberry","description":"Rust is a new programming language (first stable version 2015) that has quickly gained popularity. It is particularly suitable for low-level programming similar to C/C++. The decisive advantage over C: References always point to a valid memory and can never return NULL. Therefore memory access violations are impossible. Besides this crucial advantage, Rust has the following features:","topic":"coding"}',

    13 => '{"imgsrc":"./img/gear/breadboard.png","name":"Breadborad","description":"Breadboards are indispensable tools when learning electronics or prototyping new designs, and are thus frequently used in the Arduino environment. But what exactly are they? A breadboard or solderless breadboard is great for making temporary circuits and prototypes. Since no soldering is required to create a circuit, they are perfect for temporary designs or for quickly testing ideas. They can also be used over and over again.","topic":"gear"}',
    14 => '{"imgsrc":"./img/gear/microSD.png","name":"Micro SD Card","description":"In 2019, microSD Express cards debuted. Like full-size SD Express cards, microSD Express uses the PCI Express (PCIe) bus and provides a huge speed increase to as much as 985 MB/sec. For example, a file in a microSD Express card can transfer nearly five times faster than a UHS-I microSD card (see SD card classes). See SD Express, SD card, SD card classes and gruvi card.","topic":"gear"}',
    15 => '{"imgsrc":"./img/gear/microUSB.png","name":"Micor USB -Cable","description":"MicroUSB is a serial bus system based on the USB standard and is mainly used for small devices such as compact cameras and cell phones. For example, you can connect your MP3 player to your PC or charge your cell phone with a compatible power adapter using a microUSB plug.","topic":"gear"}',
    16 => '{"imgsrc":"./img/gear/netzteil.png","name":"Power Supply 5W","description":"Power supplies are used in most electric equipment. By definition, a power supply is a device that converts the output from an ac power line to a steady dc output or multiple outputs. The ac voltage is first rectified to provide a pulsating dc and then filtered to produce a smooth voltage.","topic":"gear"}',
    17 => '{"imgsrc":"./img/gear/sticker.png","name":"Raspberry Sticker","description":"Put it where ever you want and have fun with it","topic":"gear"}',
    18 => '{"imgsrc":"./img/gear/usbc.png","name":"USBC -Cable","description":"The connection type Universal Serial Bus, USB for short, has been a household name in the technology landscape for two decades now. Over time, USB has evolved from a data transfer cable to a standard connection for printers, mice or keyboards. USB Type C also offers Power Delivery, which supplies devices with power.","topic":"gear"}',

    19 => '{"imgsrc":"./img/raspi/esp32DIY.png","name":"ESP32 DIY Camera","description":"ESP32-CAM is a low-cost ESP32-based development board with onboard camera, small in size. It is an ideal solution for IoT application, prototypes constructions and DIY projects. The board integrates WiFi, traditional Bluetooth and low power BLE , with 2 high- performance 32-bit LX6 CPUs.","topic":"raspberry & controllers"}',
    20 => '{"imgsrc":"./img/raspi/pico.png","name":"Raspberry Pi Pico","description":"Raspberry Pi Pico is a low-cost, high-performance microcontroller board with flexible digital interfaces, built on silicon designed at Raspberry Pi. Key features include: RP2040 microcontroller chip designed by Raspberry Pi in the United Kingdom. Dual-core ARM Cortex M0+ processor, flexible clock running up to 133 MHz.", "topic":"raspberry & controllers"}',
    21 => '{"imgsrc":"./img/raspi/picoW.png","name":"Raspberry Pi Pico W","description":"Network your Pico for a complete IoT solution. Raspberry Pi Pico W comes with a fully certified module on board featuring 2.4GHz 802.11n wireless LAN, making it the perfect solution for loT applications and projects requiring wireless communication. Pico W is available now for $6.","topic":"raspberry & controllers"}',
    22 => '{"imgsrc":"./img/raspi/raspi4.png","name":"Raspberry Pi 4","description":"This is the most recent version of the low-cost Raspberry Pi computer. The Raspberry Pi isnt your average device; in its most basic form, its a credit-card-sized circuit board thats similar to those found inside a PC/laptop, but much smaller.","topic":"raspberry & controllers"}',
    23 => '{"imgsrc":"./img/raspi/rtc.png","name":"Real time clock moudle","description":"An RTC keeps track of the time even when the main power supply is turned off. Without an RTC, the user would need to set the time and date every time the device is turned on. Todays electronic devices have access to the Internet or GPS. Once the device has connected, it can very easily acquire the accurate time.","topic":"raspberry & controllers"}',
    24 => '{"imgsrc":"./img/raspi/chip.png","name":"RP 2040","description":"Flexible I/O connects RP2040 to the physical world by allowing it to speak to almost any external device. ","topic":"raspberry & controllers"}'
    );

    # send and get data with post 
    # js -> post  
    # php -> post
    $boxDate="";

    if(isset($_POST['boxId'])){
        $var = $_POST['boxId'];

        if($var >= 10){
            $boxDate= "2022/12/$var";
        }else{
            $boxDate= "2022/12/0$var";
        }

        if(date("Y/m/d") < $boxDate){
            $dateNow = date("Y/m/d");
            echo "$dateNow < $boxDate";
        }else{
            echo $adventCalender[$var];
        }

    }else{
        echo "error while sending data";
    }
   
?>

