package de.aicard.storages;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ChatRepositoryTest {
//    Faculty APPLIED_COMPUTER_SCIENCE ;
//    @Autowired
//    ChatRepository chatRepository;
//    @Autowired
//    AccountRepository accountRepository;
//    @Autowired
//    MessageRepository messageRepository;
//
//    @BeforeEach
//    public void beforeEach() {
//
//    }
//
//    @AfterEach
//    public void afterEach() {
//
//        chatRepository.deleteAll();
//        accountRepository.deleteAll();
//        messageRepository.deleteAll();
//    }
//
//    @Test
//    void save() {
//        // GIVEN
//
//        Student givenStudent1 = new Student ("email1@fh-erfurt.de","password1","student1","std1",1,APPLIED_COMPUTER_SCIENCE);
//        Student givenStudent2 = new Student ("email2@fh-erfurt.de","password2","student2","std2",1,APPLIED_COMPUTER_SCIENCE);
//
//        accountRepository.save(givenStudent2);
//        accountRepository.save(givenStudent1);
//
//        Chat givenChat = new Chat(givenStudent1,givenStudent2,"This is a new message ");
//
//        Message firstMessage = givenChat.getChatHistory().get(0);
//        messageRepository.save(firstMessage);
//
//        // WHEN
//        Chat result = chatRepository.save(givenChat);
//        Long resultId = result.getId();
//
//        // THEN
//        Assertions.assertTrue(resultId != null && resultId >0);
//
//    }
//
//
//    @Test
//    void findAll() {
//        // GIVEN
//        Student givenStudent1 = new Student ("email1@fh-erfurt.de","password1","student1","std1",1,APPLIED_COMPUTER_SCIENCE);
//        Student givenStudent2 = new Student ("email2@fh-erfurt.de","password2","student2","std2",1,APPLIED_COMPUTER_SCIENCE);
//        Student givenStudent3 = new Student ("email3@fh-erfurt.de","password3","student3","std3",1,APPLIED_COMPUTER_SCIENCE);
//
//        accountRepository.save(givenStudent1);
//        accountRepository.save(givenStudent2);
//        accountRepository.save(givenStudent3);
//
//        Chat givenChat1 = new Chat(givenStudent1,givenStudent2,"This is a new message ");
//        Chat givenChat2 = new Chat(givenStudent1,givenStudent3,"This is a new message ");
//
//        Message messageChat1 = givenChat1.getChatHistory().get(0);
//        Message messageChat2 = givenChat2.getChatHistory().get(0);
//
//        messageRepository.save(messageChat1);
//        messageRepository.save(messageChat2);
//
//        List<Long> idsOfPersisted = new ArrayList<>();
//        Chat saved1 = chatRepository.save(givenChat1);
//        Chat saved2 = chatRepository.save(givenChat2);
//        idsOfPersisted.add(saved1.getId());
//        idsOfPersisted.add(saved2.getId());
//
//        // WHEN
//        List<Chat> result = chatRepository.findAll();
//
//        Assertions.assertTrue(result != null && !result.isEmpty());
//        Assertions.assertFalse(idsOfPersisted.isEmpty());
//    }
//
//
//    @Test
//    void findByParticipants() {
//        // GIVEN
//        Student givenStudent1 = new Student ("email1@fh-erfurt.de","password1","student1","std1",1,APPLIED_COMPUTER_SCIENCE);
//        Student givenStudent2 = new Student ("email2@fh-erfurt.de","password2","student2","std2",1,APPLIED_COMPUTER_SCIENCE);
//        Student givenStudent3 = new Student ("email3@fh-erfurt.de","password3","student3","std3",1,APPLIED_COMPUTER_SCIENCE);
//
//        accountRepository.save(givenStudent1);
//        accountRepository.save(givenStudent2);
//        accountRepository.save(givenStudent3);
//
//        Chat givenChat1 = new Chat(givenStudent1,givenStudent2,"This is a new message ");
//        Chat givenChat2 = new Chat(givenStudent1,givenStudent3,"This is a new message ");
//
//        Message messageChat1 = givenChat1.getChatHistory().get(0);
//        Message messageChat2 = givenChat2.getChatHistory().get(0);
//
//        messageRepository.save(messageChat1);
//        messageRepository.save(messageChat2);
//
//        chatRepository.save(givenChat1);
//        chatRepository.save(givenChat2);
//
//
//        //WHEN
//        Optional<Chat> result = chatRepository.findByParticipants(givenStudent3);
//        Assertions.assertTrue(result.isPresent());
//        Assertions.assertEquals(result.get(),givenChat2);
//
//
//
//
//
//    }



}