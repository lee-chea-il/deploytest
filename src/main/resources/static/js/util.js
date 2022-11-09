function loadMessage(root, fileName, path) {
  window[fileName] = root.lookupType(path);
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
  
  console.log("deserialized" + fileName + "ToSend mmmmmmmmmmmm>>", window[decodedFileData]);
  
  return window[encodedFileData];
}

function getEncodedData(name) {
  return window['encoded' + name + 'Data'];
}

function getDecodedData(name) {
  return window['decoded' + name + 'Data'];
}

//---------------------------------------------------------------------------------------------------
// 데이터를 받을때 현재 event.data를 통해서 전달된 데이터를 열어보게되면 blob형태로 전달받게되고
// 그 데이터를 읽기위해서는 FileReader를 통해서 Arraybuffer로 읽을 수 있다.
// 하지만 Protobuf에서 message 객체로 읽기위해서는 Unit8Array로 읽어야한다.
// 그래서 최종적으로 decode한 데이터를 변수에 담아서 리턴한다.
// 여기서 한가지 문제가 생기는데 fileReader.onload는 비동기적으로 실행됙때문에 리턴값을 받아볼수없다.
// 비동기적인 동작을 동기적으로 바꾸기위해서는 Promise객체안에 담아서 resolve로 리턴한 후,
// onMessage에서 async로 함수를 명시한 후, 안에다가 await로 promise객체를 받아주면
// 동기적으로 리턴값을 받아낼 수있다.

function readBlobDataAsync(blob, fileName) {
  return new Promise((resolve, reject) => {

    const fileReader = new FileReader();

    fileReader.onload = function(event) {
      const arrayBuffer = event.target.result;
      const receivedFileDataName = 'received' + fileName + 'Data';

      window[receivedFileDataName] = window[fileName].decode(new Uint8Array(arrayBuffer));

      console.log("receivedPacketData mmmmmmmmmmmm>>", window[receivedFileDataName]);
      
      resolve(window[receivedFileDataName]);
    };

    fileReader.readAsArrayBuffer(blob);

  });
}




