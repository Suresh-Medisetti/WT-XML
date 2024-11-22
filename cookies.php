<?php
// Setting a cookie
// The cookie name is "user", and the value is "John Doe". It will expire in 1 hour.
setcookie("user", "John Doe", time() + 3600, "/");

// Checking if the cookie is set
if (isset($_COOKIE["user"])) {
    echo "Cookie 'user' is set!<br>";
    echo "Value: " . $_COOKIE["user"] . "<br>";
} else {
    echo "Cookie 'user' is not set!<br>";
}

// Updating a cookie value
if (isset($_COOKIE["user"])) {
    setcookie("user", "Jane Doe", time() + 3600, "/");
    echo "Cookie 'user' updated to: Jane Doe<br>";
}

// Deleting a cookie
// To delete a cookie, set its expiration time in the past.
if (isset($_COOKIE["user"])) {
    setcookie("user", "", time() - 3600, "/");
    echo "Cookie 'user' has been deleted.";
}
?>
