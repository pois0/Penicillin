package jp.nephy.penicillin.exception

class InvalidOrExpiredToken: AbsTwitterErrorMessage(89, "Invalid or expired token", "The access token used in the request is incorrect or has expired.")