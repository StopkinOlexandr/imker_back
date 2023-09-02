package de.imker.controllers;


import de.imker.models.Event;
import de.imker.repositories.EventsRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EventController is works: ")
@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EventsRepository eventsRepository;

    @Nested
    @DisplayName("getAllEvents() method is works: ")
    class addEventTest {
        @Test
        void add_event() throws Exception {
            mockMvc.perform(post("/api/events")
                            .header("Content-Type", "application/json")
                            .content("\n" +
                                    "{\n" +
//                                    "  \"id\": \"13\",\n" +
                                    "  \"title\": \"Bienenforschung und Wissenschaft: Aktuelle Erkenntnisse zur Bienenhaltung!\",\n" +
                                    "  \"description\": \"Tauchen Sie ein in die faszinierende Welt der Bienenforschung!\",\n" +
                                    "  \"shortDescription\": \"Seminar: Bienenforschung und Wissenschaft\",\n" +
                                    "  \"author\": \"Bienenforscherin Dr. Anna Schneider\",\n" +
                                    "  \"location\": \"Bremen, CircusHof, 11\",\n" +
                                    "  \"quantityOfMembers\": \"30\",\n" +
                                    "  \"photo\": \"101\",\n" +
                                    "  \"dateStart\": \"2023-03-10\",\n" +
                                    "  \"dateEnd\": \"2023-03-10\",\n" +
                                    "  \"startTime\": \"10:00\",\n" +
                                    "  \"endTime\": \"16:00\",\n" +
                                    "  \"address\": \"Bienenforschungsinstitut, Musterstadt\"\n" +

                                    "\n" +
                                    "}"))
                    .andExpect(status().isCreated())
                    // .andExpect(jsonPath("$.id", is(13)))
                    .andExpect(jsonPath("$.title", is("Bienenforschung und Wissenschaft: Aktuelle Erkenntnisse zur Bienenhaltung!")))
                    .andExpect(jsonPath("$.description", is("Tauchen Sie ein in die faszinierende Welt der Bienenforschung!")))
                    .andExpect(jsonPath("$.shortDescription", is("Seminar: Bienenforschung und Wissenschaft")))
                    .andExpect(jsonPath("$.author", is("Bienenforscherin Dr. Anna Schneider")))
                    .andExpect(jsonPath("$.location", is("Bremen, CircusHof, 11")))
                    .andExpect(jsonPath("$.quantityOfMembers", is(30)))
                    .andExpect(jsonPath("$.photo", is("101")))
                    .andExpect(jsonPath("$.dateStart", is("2023-03-10")))
                    .andExpect(jsonPath("$.dateEnd", is("2023-03-10")))
                    .andExpect(jsonPath("$.startTime", is("10:00")))
                    .andExpect(jsonPath("$.endTime", is("16:00")))
                    .andExpect(jsonPath("$.address", is("Bienenforschungsinstitut, Musterstadt")));
        }
    }


    @Nested
    @DisplayName("getAllEvents() method is works: ")
    class GetAllEventsTests {
        @Test
        void get_all_events() throws Exception {
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());

            mockMvc.perform(get("/api/events/getAll"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(11)));
        }


    }


    @Nested
    @DisplayName("deleteEvent() method is works: ")
    class DeleteEventTests {
        @Test
        void delete_exists_event() throws Exception {
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());

            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isOk());
        }

        @Test
        void delete_not_exist_event() throws Exception {
            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isNotFound());
        }

    }
}












