package com.example.assignment1;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemName.setText(item.getName());

        // Get the shape of item in order to show the right widgets
        int shapeNum = item.getShape();

        // Area of Square
        //===============
        if(shapeNum == 1){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r1);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.SquareLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String num,res;
                            float number, result;
                            num = holder.SquareEditText.getText().toString();
                            if (!num.isEmpty()){
                                if (num.matches("\\d*\\.?\\d+")){
                                    number = Float.parseFloat(num);
                                    result = number * number;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                } else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.SquareLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });

            // Perimeter of square
            //====================
        } else if (shapeNum == 2){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r1);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.SquareLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String num,res;
                            float number, result;
                            num = holder.SquareEditText.getText().toString();
                            if (!num.isEmpty()){
                                if (num.matches("\\d*\\.?\\d+")){
                                    number = Float.parseFloat(num);
                                    result = 4 * number;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                } else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.SquareLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of rectangle
            //==================
        } else if (shapeNum == 3) {
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r2);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.heightLayout.setVisibility(View.VISIBLE);
                    holder.widthLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a, b, res;
                            float number1, number2, result;
                            a = holder.heightEditText.getText().toString();
                            b = holder.widthEditText.getText().toString();
                            if (!(a.isEmpty() | b.isEmpty())) {
                                if (a.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+")) {
                                    number1 = Float.parseFloat(a);
                                    number2 = Float.parseFloat(b);
                                    result = number2 * number1;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                            }
                        }
                    });
                } else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.heightLayout.setVisibility(View.GONE);
                    holder.widthLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
        }
        // Perimeter of rectangle
        //========================
        else if (shapeNum == 4){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r2);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.heightLayout.setVisibility(View.VISIBLE);
                    holder.widthLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a,b,res;
                            float number1,number2, result;
                            a = holder.heightEditText.getText().toString();
                            b = holder.widthEditText.getText().toString();
                            if (!(a.isEmpty() | b.isEmpty())){
                                if (a.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+")){
                                    number1 = Float.parseFloat(a);
                                    number2 = Float.parseFloat(b);
                                    result = 2*(number2 + number1);
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                } else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.heightLayout.setVisibility(View.GONE);
                    holder.widthLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of triangle
            //=================
        } else if (shapeNum == 5){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r3);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.BaseLayout.setVisibility(View.VISIBLE);
                    holder.heightForTLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String b,h,res;
                            float base,height, result;
                            b = holder.baseEditText.getText().toString();
                            h = holder.heightTEditText.getText().toString();
                            if (!(h.isEmpty() | b.isEmpty())){
                                if (h.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+")){
                                    base = Float.parseFloat(b);
                                    height = Float.parseFloat(h);
                                    result = (float) (0.5 * base * height);
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.BaseLayout.setVisibility(View.GONE);
                    holder.heightForTLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Perimeter of triangle
            //=======================
        } else if (shapeNum == 6){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r3);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.TLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a,b,c,res;
                            float A,B,C, result;
                            a = holder.t1EditText.getText().toString();
                            b = holder.t2EditText.getText().toString();
                            c = holder.t3EditText.getText().toString();
                            if (!(a.isEmpty() | b.isEmpty()| c.isEmpty())){
                                if (a.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+") & c.matches("\\d*\\.?\\d+")){
                                    A = Float.parseFloat(a);
                                    B = Float.parseFloat(b);
                                    C = Float.parseFloat(c);

                                    result = A + B + C;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.TLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of circle
            //===============
        } else if (shapeNum == 7){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r4);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.radiusLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String r,res;
                            float radius, result;
                            r = holder.radiusEditText.getText().toString();
                            if (!(r.isEmpty())){
                                if (r.matches("\\d*\\.?\\d+")){
                                    radius = Float.parseFloat(r);
                                    result = (float) (radius * radius * Math.PI);
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.radiusLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Perimeter of circle
            //====================
        } else if (shapeNum ==8){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r4);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.radiusLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String r,res;
                            float radius, result;
                            r = holder.radiusEditText.getText().toString();
                            if (!(r.isEmpty())){
                                if (r.matches("\\d*\\.?\\d+")){
                                    radius = Float.parseFloat(r);
                                    result = (float) (2 * radius * Math.PI);
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.radiusLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of trapezoid
            //==================
        } else if (shapeNum == 9){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r5);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.trapezoidALayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String b1,b2,h,res;
                            float base1,base2, height,result;
                            b1 = holder.trapezoid1AEditText.getText().toString();
                            b2 = holder.trapezoid2AEditText.getText().toString();
                            h = holder.TheightEditText.getText().toString();
                            if (!(b1.isEmpty() | b2.isEmpty() | h.isEmpty())){
                                if (b1.matches("\\d*\\.?\\d+") && b2.matches("\\d*\\.?\\d+") && h.matches("\\d*\\.?\\d+")){
                                    base1 = Float.parseFloat(b1);
                                    base2 = Float.parseFloat(b2);
                                    height = Float.parseFloat(h);
                                    result = (float) 0.5 * (base1 + base2) * height;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.trapezoidALayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Perimeter of trapezoid
            //=======================
        } else if (shapeNum == 10){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r5);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.trapezoidPLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a,b,c,d,res;
                            float A,B,C,D, result;
                            a = holder.trapezoid1EditText.getText().toString();
                            b = holder.trapezoid2EditText.getText().toString();
                            c = holder.trapezoid3EditText.getText().toString();
                            d = holder.trapezoid4EditText.getText().toString();
                            if (!(a.isEmpty() | b.isEmpty()| c.isEmpty() | d.isEmpty())){
                                if (a.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+") & c.matches("\\d*\\.?\\d+") & d.matches("\\d*\\.?\\d+")){
                                    A = Float.parseFloat(a);
                                    B = Float.parseFloat(b);
                                    C = Float.parseFloat(c);
                                    D = Float.parseFloat(d);

                                    result = A + B + C + D;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.trapezoidPLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of diamond
            //================
        } else if (shapeNum == 11){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r6);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.diamondLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String b1,b2,res;
                            float base1,base2,result;
                            b1 = holder.diamond1EditText.getText().toString();
                            b2 = holder.diamond2EditText.getText().toString();
                            if (!(b1.isEmpty() | b2.isEmpty() )){
                                if (b1.matches("\\d*\\.?\\d+") && b2.matches("\\d*\\.?\\d+") ){
                                    base1 = Float.parseFloat(b1);
                                    base2 = Float.parseFloat(b2);
                                    result = (float) 0.5 * base1 * base2;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.diamondLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Perimeter of diamond
            //=====================
        } else if (shapeNum == 12){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r6);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.SquareLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a,res;
                            float A,result;
                            a = holder.SquareEditText.getText().toString();

                            if (!a.isEmpty()){
                                if (a.matches("\\d*\\.?\\d+")){
                                    A = Float.parseFloat(a);
                                    result = 4 * A ;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.SquareLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Area of parallelogram
            //======================
        } else if (shapeNum == 13){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r7);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.BaseLayout.setVisibility(View.VISIBLE);
                    holder.heightForTLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String b,h,res;
                            float base, height,result;
                            b = holder.baseEditText.getText().toString();
                            h = holder.heightTEditText.getText().toString();
                            if (!(b.isEmpty() | h.isEmpty())){
                                if (b.matches("\\d*\\.?\\d+") && h.matches("\\d*\\.?\\d+")){
                                    base = Float.parseFloat(b);
                                    height = Float.parseFloat(h);
                                    result = base * height;
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.BaseLayout.setVisibility(View.GONE);
                    holder.heightForTLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
            // Perimeter of parallelogram
            //===========================
        } else if (shapeNum == 14){
            // Set up an OnClickListener on the item name TextView
            holder.itemName.setOnClickListener(v -> {
                if (holder.imageOfShape.getVisibility() == View.GONE) {
                    holder.item_rule.setVisibility(View.VISIBLE);
                    holder.imageOfShape.setImageResource(R.drawable.r7);
                    holder.item_rule.setText(item.getRule());
                    holder.imageOfShape.setVisibility(View.VISIBLE);
                    holder.heightLayout.setVisibility(View.VISIBLE);
                    holder.widthLayout.setVisibility(View.VISIBLE);
                    holder.resultButton.setVisibility(View.VISIBLE);

                    holder.resultButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a,b,res;
                            float A,B,result;
                            a = holder.heightEditText.getText().toString();
                            b = holder.widthEditText.getText().toString();
                            if (!(a.isEmpty() | b.isEmpty())){
                                if (a.matches("\\d*\\.?\\d+") & b.matches("\\d*\\.?\\d+")){
                                    A = Float.parseFloat(a);
                                    B = Float.parseFloat(b);

                                    result = 2 * (A + B);
                                    res = Float.toString(result);
                                    holder.resultLayout.setVisibility(View.VISIBLE);
                                    holder.resultTextView.setText(res);
                                } else {
                                    Toast toast = Toast.makeText(v.getContext(), R.string.ErrorMessageForEnterCharactersNotNumbers, Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER , 0, 0);
                                    toast.show();
                                }
                            } else {
                                Toast toast = Toast.makeText(v.getContext(), R.string.GeneralErrorMessage, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER , 0, 0);
                                toast.show();
                            }
                        }
                    });
                }else {
                    holder.imageOfShape.setVisibility(View.GONE);
                    holder.heightLayout.setVisibility(View.GONE);
                    holder.widthLayout.setVisibility(View.GONE);
                    holder.resultButton.setVisibility(View.GONE);
                    holder.resultLayout.setVisibility(View.GONE);
                    holder.item_rule.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemName;
        private TextView item_rule;
        private ImageView imageOfShape;
        private View heightLayout;
        private EditText heightEditText;
        private View widthLayout;
        private EditText widthEditText;
        private View SquareLayout;
        private EditText SquareEditText;
        private View BaseLayout;
        private EditText baseEditText;
        private View heightForTLayout;
        private EditText heightTEditText;
        private View TLayout;
        private EditText t1EditText, t2EditText,t3EditText;
        private View radiusLayout;
        private EditText radiusEditText;
        private View trapezoidALayout;
        private EditText trapezoid1AEditText,trapezoid2AEditText, TheightEditText;
        private View trapezoidPLayout;
        private EditText trapezoid1EditText,trapezoid2EditText,trapezoid3EditText,trapezoid4EditText;
        private View diamondLayout;
        private EditText diamond1EditText,diamond2EditText;
        private Button resultButton;
        private View resultLayout;
        private TextView resultTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            item_rule = itemView.findViewById(R.id.item_rule);
            imageOfShape =  itemView.findViewById(R.id.imageOfShape);
            heightLayout =  itemView.findViewById(R.id.heightLayout);
            heightEditText =  itemView.findViewById(R.id.heightEditText);
            widthLayout =  itemView.findViewById(R.id.widthLayout);
            widthEditText =  itemView.findViewById(R.id.widthEditText);
            SquareLayout =  itemView.findViewById(R.id.SquareLayout);
            SquareEditText =  itemView.findViewById(R.id.SquareEditText);
            BaseLayout =  itemView.findViewById(R.id.BaseLayout);
            baseEditText =  itemView.findViewById(R.id.baseEditText);
            heightForTLayout =  itemView.findViewById(R.id.heightForTLayout);
            heightTEditText =  itemView.findViewById(R.id.heightTEditText);
            TLayout = itemView.findViewById(R.id.TLayout);
            t1EditText = itemView.findViewById(R.id.t1EditText);
            t2EditText = itemView.findViewById(R.id.t2EditText);
            t3EditText = itemView.findViewById(R.id.t3EditText);
            radiusLayout =  itemView.findViewById(R.id.radiusLayout);
            radiusEditText =  itemView.findViewById(R.id.radiusEditText);
            trapezoidALayout = itemView.findViewById(R.id.trapezoidALayout);
            trapezoid1AEditText = itemView.findViewById(R.id.trapezoid1AEditText);
            trapezoid2AEditText = itemView.findViewById(R.id.trapezoid2AEditText);
            TheightEditText = itemView.findViewById(R.id.TheightEditText);
            trapezoidPLayout = itemView.findViewById(R.id.trapezoidPLayout);
            trapezoid1EditText = itemView.findViewById(R.id.trapezoid1EditText);
            trapezoid2EditText = itemView.findViewById(R.id.trapezoid2EditText);
            trapezoid3EditText = itemView.findViewById(R.id.trapezoid3EditText);
            trapezoid4EditText = itemView.findViewById(R.id.trapezoid4EditText);
            diamondLayout = itemView.findViewById(R.id.diamondLayout);
            diamond1EditText = itemView.findViewById(R.id.diamond1EditText);
            diamond2EditText = itemView.findViewById(R.id.diamond2EditText);
            resultButton = itemView.findViewById(R.id.resultButton);
            resultLayout = itemView.findViewById(R.id.resultLayout);
            resultTextView = itemView.findViewById(R.id.resultTextView);

            item_rule.setVisibility(View.GONE);
            imageOfShape.setVisibility(View.GONE);
            heightLayout.setVisibility(View.GONE);
            widthLayout.setVisibility(View.GONE);
            SquareLayout.setVisibility(View.GONE);
            BaseLayout.setVisibility(View.GONE);
            TLayout.setVisibility(View.GONE);
            heightForTLayout.setVisibility(View.GONE);
            radiusLayout.setVisibility(View.GONE);
        }
    }
}