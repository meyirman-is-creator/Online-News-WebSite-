package com.example.sdu_newmenews;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class CreateUsername {
    private String username;
    private String email;
    private String password;
    private String gender;
    private boolean remembe_me = false;

    CreateUsername(String username, String email, String password, String gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }


    void creteFile() throws Exception {
        File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser");
        boolean folder = file.mkdir();
        File file1 = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
        String content = "Remember me :"+remembe_me + "\n" +
                         "Username    :"+username   + "\n" +
                         "Password    :"+password   + "\n" +
                         "Email       :"+email      + "\n" +
                         "Gender      :"+gender     + "\n~~~~~\n";
        RandomAccessFile r = new RandomAccessFile(file1 ,"rw");
        r.seek(file1.length());
        r.writeBytes(content);
        r.close();

    }
}
