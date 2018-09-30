package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    int btao;

    public BottleSong(int bottleTakenAtOnce) {
        this.btao = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        //TODO
        if ((this.btao < 100) & (this.btao > 0))
        {
            String final1 = "";
            Integer bottles = 99;
            Integer tmpBottles = 99;
            String strbtao = getBottle(this.btao);
            while (bottles > this.btao) {
                tmpBottles = bottles - this.btao;
                if (tmpBottles>1) {
                    final1 += bottles.toString() + " bottles of beer on the wall, " + bottles.toString() + " bottles of beer.\n" +
                            "Take " + strbtao + "down and pass around, " + tmpBottles.toString() + " bottles of beer on the wall.\n";
                }
                else{
                    final1 += bottles.toString() + " bottles of beer on the wall, " + bottles.toString() + " bottles of beer.\n" +
                            "Take " + strbtao + "down and pass around, " + tmpBottles.toString() + " bottle of beer on the wall.\n";
                }
                bottles = tmpBottles;
            }
            if ( bottles > 1) {
                final1 += bottles.toString() + " bottles of beer on the wall, " + bottles.toString() + " bottles of beer.\n" +
                        "Take " + getBottle(bottles) + "down and pass around, no more bottles of beer on the wall.\n" +
                        "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
            }
            else{
                final1 += bottles.toString() + " bottle of beer on the wall, " + bottles.toString() + " bottle of beer.\n" +
                        "Take " + getBottle(bottles) + "down and pass around, no more bottles of beer on the wall.\n" +
                        "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
            }
            return final1;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public String getBottle(int number){
        String str = "";
        if(number < 20) {
            switch (number) {
                case 1: str = "one ";
                    break;
                case 2: str = "two ";
                    break;
                case 3: str = "three ";
                    break;
                case 4: str = "four ";
                    break;
                case 5: str = "five ";
                    break;
                case 6: str = "six ";
                    break;
                case 7: str = "seven ";
                    break;
                case 8: str = "eight ";
                    break;
                case 9: str = "nine ";
                    break;
                case 10: str = "ten ";
                    break;
                case 11: str = "eleven ";
                    break;
                case 12: str = "twelve ";
                    break;
                case 13: str = "thirteen ";
                    break;
                case 14: str = "fourteen ";
                    break;
                case 15: str = "fifteen ";
                    break;
                case 16: str = "sixteen ";
                    break;
                case 17: str = "seventeen ";
                    break;
                case 18: str = "eighteen ";
                    break;
                case 19: str = "nineteen ";
                    break;
            }
        }
        else{
            switch (number / 10) {
                case 2: str = "twenty ";
                    break;
                case 3: str = "thirty ";
                    break;
                case 4: str = "forty ";
                    break;
                case 5: str = "fifty ";
                    break;
                case 6: str = "sixty ";
                    break;
                case 7: str = "seventy ";
                    break;
                case 8: str = "eighty ";
                    break;
                case 9: str = "ninety ";
                    break;
            }
            switch (number % 10) {
                case 0: str += "";
                    break;
                case 1: str += "one ";
                    break;
                case 2: str += "two ";
                    break;
                case 3: str += "three ";
                    break;
                case 4: str += "four ";
                    break;
                case 5: str += "five ";
                    break;
                case 6: str += "six ";
                    break;
                case 7: str += "seven ";
                    break;
                case 8: str += "eight ";
                    break;
                case 9: str += "nine ";
                    break;
            }
        }
        return str;
    }
}
