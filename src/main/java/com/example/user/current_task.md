## Token can be sent via request headers or cookies.

On user login, the first token should be issued and sent in response body as well as cookies.<br> 
The token should be stateful and should be stored in db as well.

#### - The single token lifetime should be 5 min.
#### - First 1 min should do nothing but authenticate.
#### - Second minute onwards to single token lifetime, if any api is hit, then, update the token. This updated token should be sent in headers as well as cookies.
#### - if the single token lifetime gets expired then it should be blacklisted.
#### - The rotation of the tokens should last for 6 hours after that, the user has to log in again (contiguous session time limit).
#### - So it is important to keep track of the session.
#### - The token must also contain the information of the ip address of the client. If the user logs in from another ip address while their session is live, then, log out.
#### - rate limit the api to "1 requests/second"