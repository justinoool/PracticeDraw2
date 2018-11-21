package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(20, 70);
        path.rLineTo(20, 70);
        path.rLineTo(50, -120);
        path.rLineTo(70, 70);
        path.rLineTo(40, -90);
        path.rLineTo(120, 50);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.setPathEffect(new CornerPathEffect(5));
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(50, 0);
        // 第二处：DiscretePathEffect
        paint.setPathEffect(new DiscretePathEffect(20,5));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 100);
        // 第三处：DashPathEffect
        paint.setPathEffect(new DashPathEffect(new float[]{20,10,10,5},0));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 150);
        // 第四处：PathDashPathEffect
        Path path = new Path();
        path.moveTo(50,50);
        path.rLineTo(75,75);
        path.rLineTo(25,75);
        path.rLineTo(50,50);
        paint.setPathEffect(new PathDashPathEffect(path,10,0, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第五处：SumPathEffect
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20, 10, 10, 5}, 0);
        CornerPathEffect cornerPathEffect = new CornerPathEffect(5);
        SumPathEffect sumPathEffect = new SumPathEffect(dashPathEffect, cornerPathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 250);
        DashPathEffect effect1 = new DashPathEffect(new float[]{20, 10, 10, 5}, 0);
        CornerPathEffect effect2 = new CornerPathEffect(5);
        paint.setPathEffect(new ComposePathEffect(effect1,effect2));
        // 第六处：ComposePathEffect
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
