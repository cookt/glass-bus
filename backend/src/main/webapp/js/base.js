

/** global namespace for brainpower projects. */
var brainpower=brainpower || {};

/**
 * Client ID of the application (from the APIs Console).
 * @type {string}
 */
brainpower.CLIENT_ID='811610137205-mgmpasu6lcl68mkotkt84modr4imfs9l.apps.googleusercontent.com';

/**
 * Scopes used by the application.
 * @type {string}
 */
brainpower.SCOPES='https://www.googleapis.com/auth/userinfo.email';

/**
 * Whether or not the user is signed in.

 * @type {boolean}
 */
brainpower.signedIn=false;

brainpower.user=null;
/**
 * Loads the application UI after the user has completed auth.
 */
brainpower.userAuthed = function() {
  var request = gapi.client.oauth2.userinfo.get().execute(function(resp) {
    console.log(resp);
    brainpower.user=resp.email;
    if (!resp.code) {
      brainpower.signedIn = true;
      document.querySelector('#signinButton').textContent = 'Sign out';

    }
  });
};

/**
 * Handles the auth flow, with the given value for immediate mode.
 * @param {boolean} mode Whether or not to use immediate mode.
 * @param {Function} callback Callback to call on completion.
 */
brainpower.signin = function(mode, callback) {
  gapi.auth.authorize({client_id: brainpower.CLIENT_ID,
      scope: brainpower.SCOPES, immediate: mode},
      callback);
};
/**
 * Presents the user with the authorization popup.
 */
brainpower.auth = function() {
  if (!brainpower.signedIn) {
    brainpower.signin(false,
        brainpower.userAuthed);
  } else {
    brainpower.signedIn = false;
    document.querySelector('#signinButton').textContent = 'Sign in';
  }
};

// A function that attaches a "Say Hello" button click handler
function enableClick() {
  document.getElementById('helloButton').onclick = function() {
    var name = document.getElementById('nameInput').value;
    gapi.client.myApi.sayHi({'name': name}).execute(
      function(response) {
        var outputAlertDiv = document.getElementById('outputAlert');
        outputAlertDiv.style.visibility = 'visible';

        if (!response.error) {
          outputAlertDiv.className = 'alert alert-success';
          outputAlertDiv.innerHTML = '<h2>' + response.result.data + '</h2>';
        }
        else if (response.error) {
          outputAlertDiv.className = 'alert alert-danger';
          outputAlertDiv.innerHTML = '<b>Error Code: </b>' + response.error.code + ' [' + response.error.message + ']';
        }
      }
    );
    return false;
  }
}

/**
*  If the user is signed in, the active image in the gallery should be added to the
*  user's transfer queue
*/
brainpower.sendImage=function(){
   var gal=$("#galleria");
   var image=gal.data('galleria').getActiveImage();
   console.log("image:"+image.src);
   if (!brainpower.signedIn){
       console.log("Sign in to send images");
   } else{
        gapi.client.glassbus.scheduleForTransfer({'image':image.src},{'user':brainpower.user}).execute(
            function(response){
                console.log(response);
                if (!response.error){
                    console.log("Errrrr");
                }
                else{
                    console.log("Success");
                }
            }
        );
   }
};

brainpower.enableButtons=function(){9
     var galleria=$('#galleria');
     galleria.append("<img src=assets/pickachu.png>");
     // Load the classic theme
     Galleria.loadTheme('js/galleria-1.4.2/galleria/themes/classic/galleria.classic.min.js');
     // Initialize Galleria
     Galleria.run('#galleria');

     var sendButton = document.querySelector('#send');
     sendButton.addEventListener('click',brainpower.sendImage);

     var signinButton = document.querySelector('#signinButton');
     signinButton.addEventListener('click', brainpower.auth);
};

// This is called initially
function init() {
  var apisToLoad;
  var apiName = 'glassbus';
  var apiVersion = 'v1';
  var apiRoot = 'https://' + window.location.host + '/_ah/api';
  if (window.location.hostname == 'localhost'
      || window.location.hostname == '127.0.0.1'
      || ((window.location.port != "") && (window.location.port > 1023))) {
        // We're probably running against the DevAppServer
        apiRoot = 'http://' + window.location.host + '/_ah/api';
  }
  var callback = function() {
    brainpower.enableButtons();
    if (--apisToLoad == 0) {
          brainpower.enableButtons();
          brainpower.signin(true,brainpower.userAuthed);
        }
  }
  apisToLoad=2;
  gapi.client.load(apiName, apiVersion, callback, apiRoot);
  gapi.client.load('oauth2', 'v2', callback);


};

