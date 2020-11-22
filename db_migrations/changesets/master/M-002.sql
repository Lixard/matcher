ALTER TABLE matcher.files
    RENAME TO pictures;
ALTER TABLE matcher.pictures
    RENAME COLUMN file_id TO picture_id;