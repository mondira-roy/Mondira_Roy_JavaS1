package com.company.Controller;

import com.company.model.Magic8Ball;
import com.company.model.QuoteService;
import com.company.model.WordService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


 @RestController
public class QuoteWordAndMagic8BallApplicationController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public QuoteService newquote() {

        QuoteService quotes = new QuoteService();
        Random rand= new Random();
        int number= rand.nextInt(10)+1;

        switch (number) {
            case 1:
                quotes.setQuote("People will forget what you said,people will forget what you did, But people will never forget how you made them feel");
                quotes.setAuthor("Maya Angelou");
                break;
            case 2:
                quotes.setQuote("The meaning of life is to find your gift, the purpose of life is to gift it away.");
                quotes.setAuthor("William Shakespeare");
                break;
            case 3:
                quotes.setQuote("If light is in your heart, you will find your way home.");
                quotes.setAuthor("Rumi Jaffrey");
                break;
            case 4:
                quotes.setQuote("Our lives are defined by opportunities, even the ones we miss.");
                quotes.setAuthor("F Scott Fitzgerald");
                break;
            case 5:
                quotes.setQuote("Don't surrender all your joys for an idea you used to have about yourself that isn't true anymore.");
                quotes.setAuthor("Cheryl Strayed");
                break;
            case 6:
                quotes.setQuote("It takes a great deal of courage to see the world in all its tainted glory and still love it.");
                quotes.setAuthor("Oscar Wilde");
                break;
            case 7:
                quotes.setQuote("A single dream is more powerful than a thousand realities");
                quotes.setAuthor("J R R Tolkein");
                break;
            case 8:
                quotes.setQuote("You can't wait for inspiration,you have to go after it with a club");
                quotes.setAuthor("Jack London");
                break;
            case 9:
                quotes.setQuote("Hardships often prepare ordinary people to have an extraordinary destiny.");
                quotes.setAuthor("C S Lewis");
                break;
            case 10:
                quotes.setQuote("It is never too late to be what you might have been");
                quotes.setAuthor("George Eliot");
                break;
            default:
                throw new IllegalArgumentException("You must enter a whole number between 0 and 9.");
        }

        return quotes;
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<WordService> getWordDefinition()
        {
        List<WordService> wordList = new ArrayList<>();

        // retrieve logic here
        try {
            //read the json
            ObjectMapper mapper = new ObjectMapper();
            wordList = mapper.readValue(new File("wordList.json"),
                    new TypeReference<List<WordService>>() {
                    });

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
            Random gen= new Random();
              int wordlistsize = wordList.size();
              int index = gen.nextInt(wordlistsize+1);
            List<WordService> wordListRand = new ArrayList<>(10);
                  wordListRand.add(0,wordList.get(index));

// Return a random word from the json file named wordList
            return wordListRand;
    }

    @RequestMapping(value = "/Magic8Ball", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Magic8Ball newmagic8Ball(@RequestBody @Valid Magic8Ball question) {

        Magic8Ball answers = new Magic8Ball();
         List<String> answerList = new ArrayList<>();

        answerList.add(" Fine, Thank you. ");
        answerList.add(" Maybe, But why do you ask? ");
        answerList.add(" Sometimes I have my day. ");
        answerList.add("Never Again would I indulge. ");
        answerList.add("Not now, Thanks for your concern.");
        answerList.add("It is better this way.");

        Random gen = new Random();
            int index = gen.nextInt(6)+1;
       String answer = answerList.get(index);
       question.setAnswer(answer);
   return question;
        }
    }