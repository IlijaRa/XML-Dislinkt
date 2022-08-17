import React from 'react'

export default function HomePage({user}) {
console.log('user', user)
  

  return (
    <div><div id="card">
    
    <h1>{user.name}{" "} {user.username} <br/>
    </h1>
    
    <div className="image-crop">
      <img
        id="avatar"
        src="https://drive.google.com/uc?id=1EVA3KUBLxCXF2EGmTf4LUB8F4yAvBrjl"
      />
    </div>
    <div id="bio">
      <p>
        Hello, my name is John! Bacon ipsum dolor amet short ribs prosciutto strip
        steak, pig ham tongue buffalo beef ribs hamburger pork venison.{" "}
      </p>
    </div>
    <div id="stats">
      <div className="col">
        <p className="stat">108</p>
        <p className="label1">Posts</p>
      </div>
      <div className="col">
        <p className="stat">457</p>
        <p className="label1">Followers</p>
      </div>
      <div className="col">
        <p className="stat">229</p>
        <p className="label1">Following</p>
      </div>
    </div>
    <div id="buttons">
      <button class="btn btn-primary" >Follow</button>
      <button class="btn btn-light" id="msg">Message</button>
    </div>
  </div>
  </div>
  )
}
