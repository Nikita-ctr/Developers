package net.nik.security.email;

public interface EmailSender {
    void send(String to, String email);
}