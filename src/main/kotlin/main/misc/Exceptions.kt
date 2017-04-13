package main.misc

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate item.")
class DuplicateItemException: RuntimeException() {}

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No content found.")
class NoContentException: RuntimeException() {}
