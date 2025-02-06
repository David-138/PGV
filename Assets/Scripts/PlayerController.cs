using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using TMPro;

public class PlayerController : MonoBehaviour
{
    private Rigidbody rb;
    private float movementX;
    private float movementY;
    public float speed = 0;
    public int count;
    public TextMeshProUGUI countText;
    public GameObject winTextObject;
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        count=0;
        SetCountText();
        winTextObject.SetActive(false);
    }
    void Update(){
        if (transform.position.y < 0)
        {
            StartCoroutine(RespawnPlayer());
        }
    }
    private IEnumerator RespawnPlayer(){
        transform.position = new Vector3(0, 1, 0);
        rb.velocity = Vector3.zero;
        winTextObject.SetActive(true);
        winTextObject.GetComponent<TextMeshProUGUI>().text = "não, não amigão";
        yield return new WaitForSeconds(1f);
        winTextObject.GetComponent<TextMeshProUGUI>().text = "You Win!";
        winTextObject.SetActive(false);
    }
    private void FixedUpdate()
    {
        Vector3 movement = new Vector3(movementX, 0.0f, movementY);
        rb.AddForce(movement*speed);
    }
    void OnTriggerEnter (Collider other) 
   {
       if (other.gameObject.CompareTag("PickUp")) 
       {
           other.gameObject.SetActive(false);
           count+=1;
           SetCountText();
       }
   }
    void OnMove(InputValue movementValue)
    {
        Vector2 movementVector = movementValue.Get<Vector2>();
        movementX = movementVector.x;
        movementY = movementVector.y;
    }
    void SetCountText(){
        countText.text="Count: "+count.ToString();
        if(count>=8){
            winTextObject.SetActive(true);
            Destroy(GameObject.FindGameObjectWithTag("Enemy"));
        }
    }
    private void OnCollisionEnter(Collision collision){
        if (collision.gameObject.CompareTag("Enemy")){
            Destroy(gameObject); 
            winTextObject.gameObject.SetActive(true);
            winTextObject.GetComponent<TextMeshProUGUI>().text = "You Lose!";
        }
        if (collision.gameObject.CompareTag("Rampa")) 
       {
            StartCoroutine(boostRampa());
       }
        if (collision.gameObject.CompareTag("Wall")) {
            Vector3 collisionNormal = collision.contacts[0].normal;
            StartCoroutine(boost(collisionNormal));
        }
    }
    private IEnumerator boostRampa(){
        speed=1000;
        yield return new WaitForSeconds(0.1f);
        speed=10;
    }
    private IEnumerator boost(Vector3 collisionNormal){
        Vector3 velocityXZ = new Vector3(rb.velocity.x, 0, rb.velocity.z);
        Vector3 reflectedDirection = Vector3.Reflect(velocityXZ.normalized, collisionNormal);
        rb.velocity = reflectedDirection * 10f;
        yield return new WaitForSeconds(0.5f);
    }
}
