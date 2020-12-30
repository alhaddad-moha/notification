
//use it in (onCreate) method


 text= findViewById(R.id.text);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {

                        if(task.isSuccessful()){
                            String token= task.getResult().getToken();
                            text.setText("Token: "+token);
                        }
                        else{
                            text.setText(task.getException().getMessage());

                        }

                    }
                });
