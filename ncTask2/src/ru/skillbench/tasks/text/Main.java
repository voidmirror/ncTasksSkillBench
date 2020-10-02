package ru.skillbench.tasks.text;

public class Main {
    public static void main(String[] args) {
        ContactCard contactCard = new ContactCardImpl();
        contactCard.getInstance("BEGIN:VCARD\r\nFN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nBDAY:06-06-1944\r\n");
    }
}
