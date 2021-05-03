
class Email {
    private String from;
    private String to;
    private String body;

    public Email(String from, String to, String body) {
        this.from = from;
        this.to = to;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }
}

interface EmailSender {
    void sendEmail(Email email);
}

class EmailService1Sender implements EmailSender {

    @Override
    public void sendEmail(Email email) {
        System.out.println("The mail with email service 1 has been sent!");

    }
}

class EmailService2Sender implements EmailSender {

    @Override
    public void sendEmail(Email email) {
        System.out.println("The mail with email service 2 has been sent!");

    }
}

class EmailService3Sender implements EmailSender {

    @Override
    public void sendEmail(Email email) {
        System.out.println("The mail with email service 3 has been sent!");

    }
}

class UserRegister {

    private final EmailSender emailSender;

    UserRegister(EmailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendEmail() {
        Email email = new Email("from@test.com", "to@test.com", "Thanks for register to our page");
        emailSender.sendEmail(email);
    }

}


public class Application {

    public static void main(String[] args) {

        UserRegister register = new UserRegister(new EmailService1Sender());
        register.sendEmail();
    }

}
