package org.example;

import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static class IllegalPackageException extends RuntimeException {}
    public static class StolenPackageException extends RuntimeException {}

    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] services;
        private final RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] services) {
            this.services = services;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (MailService service : services) {
                processed = service.processMail(processed);
            }
            return realMailService.processMail(processed);
        }
    }

    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage message = (MailMessage) mail;
                String from = message.getFrom();
                String to = message.getTo();
                String msg = message.getMessage();

                if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
                    logger.warning("Detected target mail correspondence: from " + from + " to " + to + " \"" + msg + "\"");
                } else {
                    logger.info("Usual correspondence: from " + from + " to " + to);
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private final int minPrice;
        private int stolenValue = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage pkg = (MailPackage) mail;
                Package content = pkg.getContent();
                if (content.getPrice() >= minPrice) {
                    stolenValue += content.getPrice();
                    return new MailPackage(
                            pkg.getFrom(),
                            pkg.getTo(),
                            new Package("stones instead of " + content.getContent(), 0)
                    );
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage pkg = (MailPackage) mail;
                String content = pkg.getContent().getContent();

                if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }
}