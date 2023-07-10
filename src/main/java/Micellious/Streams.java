package Micellious;



import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class Streams {



public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();

    driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

    List<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);

    System.out.println(list.stream().mapToInt(s-> s).average());

}
}