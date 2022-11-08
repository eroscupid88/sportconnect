package com.sportconnect.teamrosterservice.command.interceptors;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component
public class CreateTeamRosterCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> messages) {
        return (index, command) -> {
            //TODO check if there is some logic before create team roster

            return command;
        };
    }
}
