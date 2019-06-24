using System;
using System.Windows.Forms;

namespace HanoiTower
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void PictureBox1_Click(object sender, EventArgs e)
        {
            Hide();
            Level1Form form = new Level1Form();
            form.Show();
        }

        private void PictureBox2_Click(object sender, EventArgs e)
        {
            Hide();
            Level2Form form = new Level2Form();
            form.Show();
        }

        private void PictureBox3_Click(object sender, EventArgs e)
        {
            Hide();
            Level3Form form = new Level3Form();
            form.Show();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
        }

        private void PictureBox4_Click(object sender, EventArgs e)
        {
            Hide();
            Level4Form form = new Level4Form();
            form.Show();
        }

        private void PictureBox5_Click(object sender, EventArgs e)
        {
            Hide();
            Level5Form form = new Level5Form();
            form.Show();
        }

        private void PictureBox6_Click(object sender, EventArgs e)
        {
            Hide();
            Level6Form form = new Level6Form();
            form.Show();
        }
    }
}
