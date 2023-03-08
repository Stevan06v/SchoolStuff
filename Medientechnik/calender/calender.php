<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calender</title>
    <link rel="stylesheet" href="./style.css">
    <script src="./script.js" defer></script>
</head>

<body>
    <?php
    setlocale(LC_TIME, "de_DE.utf8");
    $kal_datum = time();
    $kal_tage_gesamt = date("t", $kal_datum);
    $kal_start_timestamp = mktime(0, 0, 0, date("n", $kal_datum), 1, date("Y", $kal_datum));
    $kal_start_tag = date("N", $kal_start_timestamp);
    $kal_ende_tag = date("N", mktime(0, 0, 0, date("n", $kal_datum), $kal_tage_gesamt, date("Y", $kal_datum)));
    ?>


    <table class="kalender" style="text-align: center; ">
        <caption><?php echo utf8_decode(strftime("%B %Y", $kal_datum)); ?></caption>
        <thead>
            <tr>
                <th>Mo</th>
                <th>Di</th>
                <th>Mi</th>
                <th>Do</th>
                <th>Fr</th>
                <th>Sa</th>
                <th>So</th>
            </tr>
        </thead>
        <tbody>
            <?php

            //write me a bubble sort


            //"Subject","Start Date","Start Time","End Date","End Time","All day event","Reminder on/off","Reminder Date","Reminder Time","Categories","Description","Location","Private"


            for ($i = 1; $i <= $kal_tage_gesamt + ($kal_start_tag - 1) + (7 - $kal_ende_tag); $i++) {
                $kal_anzeige_akt_tag = $i - $kal_start_tag;
                $kal_anzeige_heute_timestamp = strtotime($kal_anzeige_akt_tag . " day", $kal_start_timestamp);
                $kal_anzeige_heute_tag = date("j", $kal_anzeige_heute_timestamp);
                if (date("N", $kal_anzeige_heute_timestamp) == 1) {
                    echo "    <tr>\n";
                }
                if (date("dmY", $kal_datum) == date("dmY", $kal_anzeige_heute_timestamp)){
                    echo "<td class=\"kal_aktueller_tag\">", $kal_anzeige_heute_tag, "</td>\n";
                }
                else if ($kal_anzeige_akt_tag >= 0 and $kal_anzeige_akt_tag < $kal_tage_gesamt){
                     echo "<td class=\"kal_standard_tag\">", $kal_anzeige_heute_tag, "</td>\n";
                }else{
                    echo "<td class=\"kal_vormonat_tag\">", $kal_anzeige_heute_tag, "</td>\n";

                }
                if (date("N", $kal_anzeige_heute_timestamp) == 7){
                    echo "    </tr>\n";
                }
            }

            $count = 0;
            $orderd_array = [];

            if (is_file('data2023.csv')) {
                $data = explode("\n", file_get_contents('data2023.csv'));
                foreach ($data as $iterator) {
                    if ($count >= 1) {
                        $attributes = explode(";", $iterator);
                        $start_date = (string)$attributes[1];
                        $subject = (string)$attributes[0];  
                        $start_time = (string)$attributes[2];
                        $end_date = (string)$attributes[3];
                        $end_time = (string)$attributes[4];
                        $all_day_event = (string)$attributes[5];
                        $reminder = (string)$attributes[6];
                        $reminder_date = (string)$attributes[7];
                        $reminder_time = (string)$attributes[8];
                        $reminder_categories = (string)$attributes[9];
                        $description = (string)$attributes[10];
                        $location = (string)$attributes[11];
                        $private = (string)$attributes[12];
                    }
                    $count++;
                }
            }
            ?>
        </tbody>
    </table>
</body>

</html>