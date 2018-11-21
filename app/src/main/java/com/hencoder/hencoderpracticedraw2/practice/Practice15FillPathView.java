package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice15FillPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();

    public Practice15FillPathView(Context context) {
        super(context);
    }

    public Practice15FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        path.moveTo(25, 50);
        path.rLineTo(25, 50);
        path.rLineTo(40, -75);
        path.rLineTo(50, 50);
        path.rLineTo(35, -60);
        path.rLineTo(75, 40);

        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0);
        // 第一处：获取 Path
       paint.getFillPath(path,path1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(250, 0);
        canvas.drawPath(path1, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 100);
        paint.setStyle(Paint.Style.STROKE);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        paint.getFillPath(path,path2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(250, 100);
        canvas.drawPath(path2, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        paint.setStrokeWidth(20);
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        paint.getFillPath(path,path3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(250, 200);
        canvas.drawPath(path3, pathPaint);
        canvas.restore();
    }
}
