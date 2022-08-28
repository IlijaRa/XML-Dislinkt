
import userServices from '../../Services/UserServices/UserServices';
import { Button } from 'bootstrap'
import React, { useRef } from 'react'
import { Card,ListGroup,ListGroupItem } from 'react-bootstrap'
import { Link } from 'react-router-dom'


export default function NewFeeds({user,posts,likePostHandler,unlikePostHandler,addCommentHandler,createPostHandler}) {
  
  function onlyUnique(value, index, self) {
    return self.indexOf(value) === index;
  }

  var unique = posts.filter(onlyUnique);

const content = useRef();
const title = useRef();
const description = useRef();
const imageLink = useRef();
const link = useRef();

    console.log('posts', unique)


  return (
    <div> <div>
       <div className="header">
    {" "}
    <h1 style={{ textAlign: "center" }}> New feeds </h1>
  </div>
  <div className="containerNewPost">
  <div className="wrapper">
    <section className="post">
      <header>Posts</header>
      <form action="#">
        <div className="content">
          <img src="https://webmuch.com/wp-content/uploads/2013/04/LinkedIn-Logo-022.png" alt="logo" />
          <div className="details">
            <p>Add new post</p>
            <div className="privacy">
              <i className="fas fa-user-friends" />
              <span>Friends</span>
              <i className="fas fa-caret-down" />
            </div>
          </div>
        </div>
        <textarea
          placeholder="Title"
          spellCheck="false"
          required=""
          defaultValue={""}
          ref= {title}
        />
          <textarea
          placeholder="What's on your mind?"
          spellCheck="false"
          required=""
          defaultValue={""}
          ref= {description}

        />
           <input
         className="form-control"
          placeholder="Image link"
          spellCheck="false"
          required=""
          defaultValue={""}
          ref= {imageLink}
        />
          <input
         className="form-control"
          placeholder="Link"
          spellCheck="false"
          required=""
          defaultValue={""}
          ref= {link}
        />

        
       
      
        <button
        onClick={() => {
          createPostHandler({
            title: title.current.value,
            description: description.current.value,
            userId: user.id,
            imageLink: imageLink.current.value,
            links: [link.current.value],
            likes: 0,
            dislikes: 0
          }
          )
         
        }}
        >Post</button>
      </form>
    </section>
 
  </div>
</div>

  
    {posts?.map((postss) => (


      <div className="container">

{postss?.map((post) => (

        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <Card className="cardContainer" style={{ width: "30rem" }}>
                
                  <Card.Body>
                    <Card.Title className="cardTitle">
                   {post?.title}
                    </Card.Title>
                    <Card.Text></Card.Text>
                  </Card.Body>
                  <ListGroup className="list-group-flush">
                    <ListGroupItem>
                      {post?.description} 
                    </ListGroupItem>
                    <ListGroupItem>
                     Likes: {post?.likes} {" "} Dislikes: {post?.dislikes} 
                    </ListGroupItem>
                    <ListGroupItem> 
          <img src={post?.imageLink} className="center" width="200"
                    height="170"
                    />
         
                    </ListGroupItem>
                    {post.links?.map((link) => (
                    <ListGroupItem> 
          Link: {link}
        
                    </ListGroupItem>
                    ))}
                  </ListGroup>
                  <Card.Body>

                  <div className="col">
                    <button
                      style={{ width: "8rem" }}
                      variant="outline-success"
                      class="btn btn-primary"
                      onClick={() => 
                        {likePostHandler(user.id,post?.id
                    )
               window.location.reload();
                  }}
                    >
                      Like
                    </button>
                    <button
                      style={{ width: "8rem" }}
                      variant="outline-success"
                      class="btn btn-danger"
                      onClick={() =>{ unlikePostHandler(user.id,post?.id
                        );
               window.location.reload();
                  }}
                    >
                      Dislike
                    </button>

                   </div>

                   {post.comments?.map((comment) => (
                   <div className="card p-3 mt-2">
<div className="d-flex justify-content-between align-items-center">
  <div className="user d-flex flex-row align-items-center">
    <img
      src="https://i.imgur.com/C4egmYM.jpg"
      width={30}
      className="user-img rounded-circle mr-2"
    />
    <span>
      <small className="font-weight-bold text-primary">{user.username}</small>{" "}
      <small className="font-weight-bold">
        {" "} {comment?.content} 
      </small>
    </span>
  </div>
  <small>3 days ago</small>
</div>
<div className="action d-flex justify-content-between mt-2 align-items-center">
  <div className="reply px-4">
    <small>Remove</small>
    <span className="dots" />
    <small>Reply</small>
    <span className="dots" />
    <small>Translate</small>
  </div>
  <div className="icons align-items-center">
    <i className="fa fa-check-circle-o check-icon text-primary" />
  </div>
</div>

</div>




))} 
<br></br>
                   <div className="mb-3">
    <label>Add a comment</label>
    <input type="text" ref={content} className="form-control" placeholder="type a comment"   />
    <button
                      style={{ width: "7rem" }}
                      variant="outline-success"
                      class="btn btn-primary"
                      onClick={() => 
                        { addCommentHandler({
                          id: 1,
                          content: content.current.value,
                          userId: user.id,
                        },post.id);
               
                  }}
                    >
                      Comment
                    </button>
  </div>
                    
                 
                  </Card.Body>
                </Card>
              </div>
            </div>
          </div>
        </div>
        ))} 
      </div>

))} 

  </div></div>
  )
}
