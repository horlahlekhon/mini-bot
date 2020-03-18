package controllers

import javax.inject.Inject
import models.{MessageRepository, UserRepository}
import play.api.mvc.{AbstractController, ControllerComponents}

class MiniBotController @Inject()(cc: ControllerComponents, messageRepository: MessageRepository, userRepository: UserRepository)
                          extends AbstractController(cc) {




}
