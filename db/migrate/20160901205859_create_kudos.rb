class CreateKudos < ActiveRecord::Migration[5.0]
  def change
    create_table :kudos do |t|
      t.string :sender
      t.text :message
      t.references :staff, foreign_key: true

      t.timestamps
    end
  end
end
