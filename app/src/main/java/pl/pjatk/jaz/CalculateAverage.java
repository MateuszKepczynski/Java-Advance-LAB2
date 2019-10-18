package pl.pjatk.jaz;

public class CalculateAverage {

    public static float doAverage(String userInput)
    {
        String str[] = userInput.split(",");
        float numOfRoll = 0, amount = 0;
        for (String i : str)
        {
            amount += Integer.parseInt(i);
            numOfRoll++;
        }
        return amount / numOfRoll;
    }
}
