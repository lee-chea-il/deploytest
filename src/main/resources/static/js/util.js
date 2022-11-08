function loadMessage(root, variablesName, path) {
  window[variablesName] = root.lookupType(path);
}

function setDataToSend(root, fileName, data) {

  var verifyMsg = window[fileName].verify(data);
  if (verifyMsg) {
    throw Error(verifyMsg);
  }

  const createdFileData = 'created' + fileName + 'Data';
  const encodedFileData = 'encoded' + fileName + 'Data';
  const decodedFileData = 'decoded' + fileName + 'Data';

  window[createdFileData] = window[fileName].create(data);
  window[encodedFileData] = window[fileName].encode(window[createdFileData]).finish();
  window[decodedFileData] = window[fileName].decode(window[encodedFileData]);
  
  return encodedFileData;
}

function getEncodedData(name) {
  return window['encoded' + name + 'Data'];
}

function getDecodedData(name) {
  return window['decoded' + name + 'Data'];
}

function readBlobDataAsync(blob, fileName) {
  return new Promise((resolve, reject) => {

    const fileReader = new FileReader();

    fileReader.onload = function(event) {
      const arrayBuffer = event.target.result;
      const deserializedFileData = 'deserialized' + fileName + 'Data';

      window[deserializedFileData] = window[fileName].decode(new Uint8Array(arrayBuffer));

      console.log("receivedDeserializedData mmmmmmmmmmmm>>", window[deserializedFileData]);
      
      resolve(window[deserializedFileData]);
    };

    fileReader.readAsArrayBuffer(blob);

  });
}




