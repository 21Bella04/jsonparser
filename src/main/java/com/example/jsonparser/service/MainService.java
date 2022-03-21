package com.example.jsonparser.service;

import com.example.jsonparser.dto.InputDto;
import com.example.jsonparser.entity.Comment;
import com.example.jsonparser.entity.Link;
import com.example.jsonparser.entity.Subreddit;
import com.example.jsonparser.repository.CommentRepository;
import com.example.jsonparser.repository.LinkRepository;
import com.example.jsonparser.repository.SubredditRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class MainService {
    private final CommentRepository commentRepository;
    private final LinkRepository linkRepository;
    private final SubredditRepository subredditRepository;
    private final static String FILE_PATH = "Disk:\\path\\path\\directory";

    public MainService(CommentRepository commentRepository, LinkRepository linkRepository, SubredditRepository subredditRepository) {
        this.commentRepository = commentRepository;
        this.linkRepository = linkRepository;
        this.subredditRepository = subredditRepository;
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void processFile(String fileName, int processNumber) {
        final String filePath = FILE_PATH + "\\" + fileName + ".json";
        Thread t1 = new Thread(() -> {
            try {
                runThread(filePath, processNumber);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }

    private void runThread(String path, int threadNumber) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(path));

        Gson gson = new Gson();
        long startTime = System.nanoTime();
        while (scan.hasNextLine()) {
            InputDto inputDto = gson.fromJson(scan.nextLine(), InputDto.class);
            Comment comment = inputDto.toCommentEntity();

            Subreddit subreddit = new Subreddit();
            subreddit.setId(comment.getSubredditId());
            subreddit.setName(inputDto.getSubreddit());
            Subreddit save = subredditRepository.save(subreddit);

            Link link = new Link();
            link.setId(comment.getLinkId());
            link.setSubredditFk(save.getId());
            linkRepository.save(link);

            save(comment);
        }
        System.out.println("DONE! " + " t" + threadNumber);
        long elapsedTime = System.nanoTime() - startTime;
        long milis = elapsedTime / 1000000;
        System.out.println("Total execution time to create 300000 records with constraints in millis: "
                + milis + "\nseconds: " + (milis/100));
    }
}