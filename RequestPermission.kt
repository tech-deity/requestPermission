 companion object{
        private const val CAMERA_PERMISSION_CODE=100
        private const val STORAGE_PERMISSION_CODE=101
        private const val storage_permission="android.Manifest.permission.WRITE_EXTERNAL_STORAGE"
        private const val camera_permission="android.Manifest.permission.CAMERA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storage:Button?=findViewById<Button>(R.id.storage_btn)
        val camera:Button?=findViewById<Button>(R.id.cameraBtn)


        storage?.setOnClickListener {

            checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE)

        }

        camera?.setOnClickListener {
            checkPermission(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)

        }



    }

    private fun checkPermission(permission:String,requestCode:Int){
        if(ContextCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_DENIED){
            //request for permission
            ActivityCompat.requestPermissions(this, arrayOf(permission),requestCode)
        }
        else{
            Toast.makeText(this,"permission is alreadyGraneted",Toast.LENGTH_SHORT).show()
        }


    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    //It is a brave man... who dares to look the devil in the face and tell him he is a devil.'
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== CAMERA_PERMISSION_CODE)
            if(grantResults.isNotEmpty()&&grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"camera permission granted ",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"camera Permission Denied FCK OFF ",Toast.LENGTH_SHORT).show()
            }
        if(requestCode== STORAGE_PERMISSION_CODE)
            if(grantResults.isNotEmpty()&& grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"storage permission granted ",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Storage Permission Denied ",Toast.LENGTH_SHORT).show()

            }
    }
}
