let codeSnippets = [
    `
    import time
    import adafruit_dht
    import board
    
    dht = adafruit_dht.DHT22(board.D2)
    
    while True:
        try:
            temperature = dht.temperature
            humidity = dht.humidity
            # Print what we got to the REPL
            print("Temp: {:.1f} *C \t Humidity: {}%".format(temperature, humidity))
        except RuntimeError as e:
            # Reading doesn't always work! Just print error and we'll try again
            print("Reading from DHT failure: ", e.args)
    
        time.sleep(1)`,
    `
    import machine
    from utime import sleep_us, ticks_us
    from time import sleep
    
    trigger = machine.Pin(5, machine.Pin.OUT)
    echo = machine.Pin(4, machine.Pin.IN)
    
    while True:
        trigger.off()
        sleep_us(2)
        trigger.on()
        sleep_us(10)
        trigger.off()
    
        while echo.value() == 0:
            pass
        ticks1 = ticks_us()
        while echo.value() == 1:
            pass
        ticks2 = ticks_us()
        cm = (ticks2 - ticks1) / 58.0
        print(cm, " cm")
        sleep(2)
    
    `,
    `
    no code available
    `,
    `
    #!/usr/bin/python
    import RPi.GPIO as GPIO
    import time
     
    #GPIO SETUP
    channel = 21
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(channel, GPIO.IN)
     
    def callback(channel):
        if GPIO.input(channel):
            print "Water Detected!"
        else:
            print "Water Detected!"
     
    GPIO.add_event_detect(channel, GPIO.BOTH, bouncetime=300)  # let us know when the pin goes HIGH or LOW
    GPIO.add_event_callback(channel, callback)  # assign function to GPIO PIN, Run function on change
     
    # infinite loop
    while True:
            time.sleep(1)
    `,

    `
    import lcd160cr
        lcd = lcd160cr.LCD160CR('X')
        lcd.set_orient(lcd160cr.PORTRAIT)
        lcd.set_pos(0, 0)
        lcd.set_text_color(lcd.rgb(255, 0, 0), lcd.rgb(0, 0, 0))
        lcd.set_font(1)
        lcd.write('Hello MicroPython!')
        print('touch:', lcd.get_touch())
    `,
    `
    import board
    import digitalio
    
    LED_PIN = board.D13  # Pin number for the board's built in LED.
    PIR_PIN = board.D2   # Pin number connected to PIR sensor output wire.
    pir = digitalio.DigitalInOut(PIR_PIN)
    pir.direction = digitalio.Direction.INPUT
    led = digitalio.DigitalInOut(LED_PIN)
    led.direction = digitalio.Direction.OUTPUT
    old_value = pir.value
    while True:
        pir_value = pir.value
        if pir_value:
            led.value = True
            if not old_value:
                print('Motion detected!')
        else:
            led.value = False
            if old_value:
                print('Motion ended!')
        old_value = pir_value
    `,
    `
    cmake_minimum_required(VERSION 3.12)
    include($ENV{PICO_SDK_PATH}/external/pico_sdk_import.cmake)

    project(blink-led C CXX ASM)
    set(CMAKE_C_STANDARD 11)
    set(CMAKE_CXX_STANDARD 17)

    pico_sdk_init()

    add_executable(PROJECT_NAME
            main.c
    )
    pico_add_extra_outputs(PROJECT_NAME)
    target_link_libraries(PROJECT_NAME
                pico_stdlib
    )
   `,
    `
   ls - The most frequently used command in Linux to list directories
   pwd - Print working directory command in Linux
   cd - Linux command to navigate through directories
   mkdir - Command used to create directories in Linux
   mv - Move or rename files in Linux
   cp - Similar usage as mv but for copying files in Linux
   rm - Delete files or directories
   touch - Create blank/empty files
   ln - Create symbolic links (shortcuts) to other files
   cat - Display file contents on the terminal
   clear - Clear the terminal display
   echo - Print any text that follows the command
   less - Linux command to display paged outputs in the terminal
   man - Access manual pages for all Linux commands
   uname - Linux command to get basic information about the OS
   whoami - Get the active username
   tar - Command to extract and compress files in Linux

   `,

    `
   import machine
   import time
   led = machine.Pin(18, machine.Pin.OUT)
   while True:
       led.on()
       time.sleep(1)
       led.off()
       time.sleep(1)
   `,
    `
   def button_reader_thread():
        global button_pressed
        while True:
            if button.value() == 1:
                button_pressed = True
   `,
    `
   import java.io.*;
   import java.util.*;
   public class CPUTemp {   
       private static final String FILE = "/sys/class/thermal/thermal_zone0/temp";
       private static final List<Integer> values = new ArrayList<>();
       public static void main(String[] args) throws InterruptedException {
           while(true) {
               checkTemp();
               Thread.sleep(1000);
           }
       }
       private static void checkTemp() {
           try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
               int value = Integer.valueOf(br.readLine());
               values.add(value);
               int total = values.stream().mapToInt(Integer::valueOf).sum();
               System.out.println("Now: " + value
                   + " - Average: " + (total / values.size())
                   + " - Number of measurements: " + values.size());
           } catch (Exception ex) {
               System.err.println("Error during temperature check: "
                   + ex.getMessage());
           }
       }
   }
   `,
    `
   use std::process::ExitCode;
   fn main() -> ExitCode {
       // ...
       if error {
         return ExitCode::from(1);
       }
       ExitCode::SUCCESS
   }
   `,
    `no code available`,
    `no code available`,
    `no code available`,
    `no code available`,
    `no code available`,
    `no code available`,

    `
   import cv2
   import numpy as np
   import requests
   
   url = "http://192.168.137.64/photo"
   resp = requests.get(url, stream=True).raw
   image = np.asarray(bytearray(resp.read()), dtype="uint8")
   image = cv2.imdecode(image, cv2.IMREAD_COLOR)
   
   # for testing
   cv2.imshow('Image - Remote ESP32 Cam image',image)
   cv2.waitKey(0)
   cv2.destroyAllWindows()
   `,

    `
   from machine import Pin
        import utime
        led = Pin(25, Pin.OUT)
        led.low()
        while True:
            led.toggle()
            print("Toggling LED")
            utime.sleep(1)
       `,
    `
   import network
   import secrets
   import time
   import urequests
   wlan = network.WLAN(network.STA_IF)
   wlan.active(True)
   wlan.connect(secrets.SSID, secrets.PASSWORD)
   print(wlan.isconnected())

   astronauts = urequests.get("http://api.open-notify.org/astros.json").json()
   number = astronauts['number']
   for i in range(number):
        print(astronauts['people'][i]['name'])
   `,
    `
   # Python program for implementation of Bubble Sort
 
   def bubbleSort(arr):
       n = len(arr)
       # optimize code, so if the array is already sorted, it doesn't need
       # to go through the entire process
       swapped = False
       # Traverse through all array elements
       for i in range(n-1):
           # range(n) also work but outer loop will
           # repeat one time more than needed.
           # Last i elements are already in place
           for j in range(0, n-i-1):
    
               # traverse the array from 0 to n-i-1
               # Swap if the element found is greater
               # than the next element
               if arr[j] > arr[j + 1]:
                   swapped = True
                   arr[j], arr[j + 1] = arr[j + 1], arr[j]
            
           if not swapped:
               # if we haven't needed to make a single swap, we
               # can just exit the main loop.
               return
    
    
   # Driver code to test above
   arr = [64, 34, 25, 12, 22, 11, 90]
    
   bubbleSort(arr)
    
   print("Sorted array is:")
   for i in range(len(arr)):
       print("% d" % arr[i], end=" ")`,

    `
    import os
    import tarfile
    from rctmodelpool import modelpool
    from pathlib import Path
    
    local_path = modelpool.sync_model("rcthub://"+config.bert_model_path)
    parent_path = Path(local_path).parent
    print("rcthub sync:",local_path)
    modeltar = tarfile.open(local_path)
    inside_folder = os.path.commonprefix(modeltar.getnames())
    real_model_path = os.path.join(parent_path, inside_folder)
    print('model folder:', real_model_path)
    if not os.path.exists(real_model_path):
        modeltar.extractall(parent_path)
        print('tar extraction:', parent_path, local_path)
    `,
    `no code available `
]


daySelector()
letItSnowOHHHLetItSNOWWW()

// checks which day it is 
function daySelector() {
    const date = new Date();

    let today = parseInt(date.getDate());

    if (today <= 24) document.getElementsByClassName('icon')[today - 1].style.border = "solid 5px gold";

}

function letItSnowOHHHLetItSNOWWW() {

    let snowIT = document.getElementById('letItSnow');

    // anpassen --> RAM schonen ;)
    for (let i = 0; i < 70; i++) {
        snowIT.innerHTML += "<div class='snow'></div>"
    }

    for (let i = 0; i < document.getElementsByClassName('snow').length; i++) {
        if (i % 6 == 0) {
            document.getElementsByClassName('snow')[i].style.color = "gold"
            document.getElementsByClassName('snow')[i].style.filter = "drop-shadow(0 0 10px gold)"
        } else if (i % 3 == 0){
            document.getElementsByClassName('snow')[i].style.color = "#ee0548"
            document.getElementsByClassName('snow')[i].style.filter = "drop-shadow(0 0 5px #ee0548)"
        }
        
}

    window.dataLayer = window.dataLayer || [];
    function gtag() { dataLayer.push(arguments); }
    gtag('js', new Date());
    gtag('config', 'G-LLWL5N9CSM'); 
}


function selectPos(pos) {

    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", "server.php", true);

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            try {
                var data = JSON.parse(this.responseText)

                document.getElementById('headText').style.display = "none"
                document.getElementById('stuff').innerHTML = generateSimplePage(data, pos - 1)

                document.getElementById('wrapperBox').style.display = "block"

                // highlight displayed code
                hljs.highlightAll();
            } catch (error) {
                console.log("Not now: " + this.responseText);
                triggerWobble(pos-1)

            }
        }
    }
    xhttp.send(`boxId=${pos}`);
}

function triggerWobble(id) {
    document.getElementsByClassName('icon')[id].classList.add("boxWOBBLE");
    console.log(document.getElementsByClassName('icon')[id].classList);

    setTimeout(() => {
        document.getElementsByClassName('icon')[id].classList.remove("boxWOBBLE");
    }, 500);
}

function back() {
    document.getElementsByClassName('upperGrid')[0].style.display = "grid"
    document.getElementById('wrapperBox').style.display = "none"
    document.getElementById('headText').style.display = "block"
}

function generateSimplePage(data, id) {
    document.getElementsByClassName("upperGrid")[0].style.display = "none"

    html = `
<div id='wrapperBox'>
   
    <div>
         <p id="topic">${data.topic.toUpperCase()} > ${data.name}</p>
        <h1 id='headLine'>${data.name}</h1>
    </div>

    <h2 style="color:white;">What is it?</h2>

    <div id='txtFlex'>
    <img id='pic' src="${data.imgsrc}" alt="" srcset="">
    <p>
        ${data.description}
    </p>
    </div>
 
<h2 style="color:white;">How To use it in a project: </h2>
<pre>
        <code>
        ${codeSnippets[id]}
        </code>
</pre>
    <div id='links'>    
       <a href="https://www.amazon.de/"> <i class="fa-brands fa-amazon amazon"></i></a>
        <i class="fa-solid fa-store other"><a href="https://de.aliexpress.com/?gatewayAdapt=glo2deu" target="_blank"></a></i>
        <i class="fa-solid fa-house home" onclick="back()"></i>
    </div>
</div>

    `
    return html;
}






